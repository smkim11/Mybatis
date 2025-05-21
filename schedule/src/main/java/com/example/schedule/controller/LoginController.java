package com.example.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.schedule.dto.Member;
import com.example.schedule.service.ILoginService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class LoginController {
	@Autowired ILoginService loginService;
	
	// 로그인
	@GetMapping({"/","/login"})
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member m, HttpSession session) {
		Member member = loginService.login(m);
		if(member != null) {
			session.setAttribute("loginInfo", member);
			loginService.insertLoginHistory(m);
			return "redirect:/loginHistory";
		}
		return "redirect:/";
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 로그인 기록
	@GetMapping("/loginHistory")
	public String loginHistory(Model model) {
		model.addAttribute("list", loginService.history());
		return "loginHistory";
	}
	
	// 비밀번호 변경
	@GetMapping("/updatePw")
	public String updatePw() {
		return "updatePw";
	}
	
	@PostMapping("/updatePw")
	public String updatePw(@RequestParam String prePw, @RequestParam String id, @RequestParam String pw) {
		if(!prePw.equals(loginService.selectPwById(id))){
			log.info("비밀번호가 일치하지 않습니다.");
			return "updatePw";
		}
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		loginService.updatePw(member);
		loginService.insertPwHistory(member);
		return "redirect:/";
	}
}
