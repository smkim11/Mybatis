package com.example.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.schedule.dto.Member;
import com.example.schedule.service.ILoginService;

import jakarta.servlet.http.HttpSession;

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
}
