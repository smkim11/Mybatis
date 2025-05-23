package com.example.signapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.signapp.dto.Employee;
import com.example.signapp.service.SignService;

@Controller
public class SignController {
	@Autowired SignService signService;
	
	// 로그인
	@GetMapping({"/","/login"})
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Employee employee) {
		return "login";
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
	public String docView() {
		// 문서 정보를 모델에 담아서 렌더링
		return "docView";
	}
	
	// 싸인페이지
	@GetMapping("/signLevel3")
	public String signLevel3() {
		return "signLevel3";
	}
	
}
