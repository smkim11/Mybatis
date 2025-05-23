package com.example.signapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.signapp.dto.SignForm;
import com.example.signapp.service.SignService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SignRest {
	@Autowired SignService signService;
	
	@PostMapping("/addSign")
	public String addSign(SignForm signForm) {
		log.info(signForm.toString());
		// service 통해서 이미지 저장 - mapper 통해서 db저장
		signService.addSign(signForm);
		return "결제 완료";
	}
	
	@GetMapping("/useId/{id}")
	public String useId(@PathVariable String id) {
		if(signService.searchId(id) != null) {
			return "no";
		}
		return "yes";
	}
}
