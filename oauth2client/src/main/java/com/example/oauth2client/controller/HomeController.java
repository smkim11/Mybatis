package com.example.oauth2client.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String home(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// authentication(인증된 UserDetails DTO getName)
		String name= authentication.getName();
		
		// authentication(인증된 UserDetails DTO getRole)
		Collection<? extends GrantedAuthority> roleList =  authentication.getAuthorities();
		// 순서가 있는(foreach가능한) 컬랙션으로 변경(Iterator)
		Iterator<? extends GrantedAuthority> iterator = roleList.iterator();
		
		GrantedAuthority gh = null;
		String role="";
		/* 하나의 roll만 설정되어있어서 반복문을 돌릴 필요없다. (여러값받을때 사용)
		while((gh=iterator.next()) != null) {
			String role = gh.getAuthority();
		}
		*/
		
		if((gh=iterator.next()) != null) {
			role = gh.getAuthority();
		}
		model.addAttribute("name", name);
		model.addAttribute("role",role);
		return "home";
	}
	
	
}
