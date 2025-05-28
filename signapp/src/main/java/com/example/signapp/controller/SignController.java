package com.example.signapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.signapp.dto.Document;
import com.example.signapp.dto.Employee;
import com.example.signapp.dto.Page;
import com.example.signapp.service.SignService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SignController {
	@Autowired SignService signService;
	
	// 로그인
	@GetMapping({"/","/login"})
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Employee employee, HttpSession session) {
		Employee e = signService.login(employee);
		if(e != null) {
			session.setAttribute("loginInfo", e);
			return "redirect:/docView";
		}
		return "login";
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	// 회원가입
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(Employee employee) {
		signService.signUp(employee);
		return "redirect:/login";
	}
	
	// 문서 페이지
	@GetMapping("/docView")
	public String docView(@RequestParam(defaultValue = "1") int currentPage, Model model) {
		// 문서 정보를 모델에 담아서 렌더링
		Page p = new Page(currentPage, 5, signService.documentCount());
		model.addAttribute("p",p);
		model.addAttribute("list",signService.documentList(p));
		return "docView";
	}
	
	// 문서 상세 페이지
	@GetMapping("/docOne")
	public String docOne(Model model, int documentNo) {
		model.addAttribute("document",signService.documentOne(documentNo));
		return "docOne";
	}
	
	// 문서 추가 
	@GetMapping("/addDoc")
	public String addDoc() {
		return "addDoc";
	}
	
	@PostMapping("/addDoc")
	public String addDoc(Document document) {
		signService.insertDocument(document);
		return "redirect:/docView";
	}
	
	// 문서 수정 (결제 안했을때 작성자만 수정)
	@GetMapping("/updateDoc")
	public String updateDoc(Model model, @RequestParam int documentNo
							,RedirectAttributes redirectAttributes, HttpSession session) {
		// 로그인한 사용자 정보
		Employee loginUser = (Employee) session.getAttribute("loginInfo");
		
		// 결제한 사람이 없고, 작성자일 경우에만 수정
		if(signService.documentOne(documentNo).getSignLevel2() == null
		&& signService.documentOne(documentNo).getSignLevel3() == null
		&& loginUser.getName().equals(signService.documentOne(documentNo).getWriter())) {
			model.addAttribute("doc", signService.documentOne(documentNo));
			return "updateDoc";
		}
		
		// 오류메세지 
		redirectAttributes.addFlashAttribute("msg","수정 불가");
		return "redirect:/docOne?documentNo="+documentNo;
	}
	
	@PostMapping("/updateDoc")
	public String updateDoc(Document document) {
		signService.updateDocument(document);
		return "redirect:/docOne?documentNo="+document.getDocumentNo();
	}
	
	// 문서 삭제
	@GetMapping("/deleteDoc")
	public String deleteDoc(Model model, @RequestParam int documentNo, @RequestParam String writer
							,RedirectAttributes redirectAttributes, HttpSession session) {
		// 로그인한 사용자 정보
		Employee loginUser = (Employee) session.getAttribute("loginInfo");
		
		// 결제한 사람이 없고, 작성자일 경우에만 삭제
		if(signService.documentOne(documentNo).getSignLevel2() == null
		&& signService.documentOne(documentNo).getSignLevel3() == null
		&& loginUser.getName().equals(signService.documentOne(documentNo).getWriter())) {
			model.addAttribute("writer",writer);
			model.addAttribute("documentNo",documentNo);
			return "deleteDoc";
		}
		
		// 오류메세지 
		redirectAttributes.addFlashAttribute("msg","삭제 불가");
		return "redirect:/docOne?documentNo="+documentNo;
	}
	
	@PostMapping("/deleteDoc")
	public String deleteDoc(@RequestParam int documentNo, @RequestParam String pw
							,@RequestParam String writer, RedirectAttributes redirectAttributes) {
		if(pw.equals(signService.searchPw(writer))) {
			signService.deleteDocument(documentNo);
			return "redirect:/docView";
		}
		
		// 오류메세지 
		redirectAttributes.addFlashAttribute("msg","삭제 오류");
		return "redirect:/docOne?documentNo="+documentNo;
	}
}
