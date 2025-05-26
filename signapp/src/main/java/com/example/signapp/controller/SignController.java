package com.example.signapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// 싸인페이지
	@GetMapping("/signLevel3")
	public String signLevel3() {
		return "signLevel3";
	}
	
}
