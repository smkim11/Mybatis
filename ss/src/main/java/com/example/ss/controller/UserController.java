package com.example.ss.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ss.domain.UserDetailDomain;
import com.example.ss.domain.UserDomain;
import com.example.ss.dto.AddUserDto;
import com.example.ss.service.UserService;

@Controller
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/addUser")
	public String addUser() {
		return "addUser";
	}
	
	@PostMapping("/addUserAction")
	public String addUserAction(AddUserDto addUserDto) {
		userService.addUser(addUserDto);
		return "redirect:/login";
	}
	
	@GetMapping("/updateUser")
	public String updateUser(Model model) {
		String loginUsername = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("userInfo",userService.selectUser(loginUsername)); 
		
		return "updateUser";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(UserDetailDomain userDetailDomain) {
		userService.update(userDetailDomain);
		return "redirect:/";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam String username, Model model) {
		
		model.addAttribute("username",username);
		return "deleteUser";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(UserDomain userDomain, RedirectAttributes redirectAttributes) {
		UserDomain userDomain2 = userService.selectByUsername(userDomain.getUsername());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		// BCryptPasswordEncoder에있는 matches() 메소드를 통해 암호화된 비밀번호를 복호화하여 비교
		if(encoder.matches(userDomain.getPassword(), userDomain2.getPassword())) {
			userService.delete(userDomain.getUsername());
			return "redirect:/logout";
		}
		System.out.println("삭제 실패");
		redirectAttributes.addAttribute("username",userDomain.getUsername());
		return "redirect:/updateUser";
	}
}
