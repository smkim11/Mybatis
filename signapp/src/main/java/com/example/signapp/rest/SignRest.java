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
	
	// 서명 추가
	@PostMapping("/addSign")
	public String addSign(SignForm signForm) {
		log.info(signForm.toString());
		// service 통해서 이미지 저장 - mapper 통해서 db저장
		return signService.addSign(signForm);
	}
	
	// 아이디 조회
	@GetMapping("/useId/{id}")
	public String useId(@PathVariable String id) {
		if(signService.searchId(id) != null) {
			return "no";
		}
		return "yes";
	}
	
	// 레벨2 결제
	@PostMapping("/signLevel2/{signImg}/{documentNo}")
	public void signLevel2(@PathVariable String signImg, @PathVariable String documentNo) {
		signService.updateSignLevel2(signImg, documentNo);
	}
	
	// 레벨3 결제
	@PostMapping("/signLevel3/{signImg}/{documentNo}")
	public void signLevel3(@PathVariable String signImg, @PathVariable String documentNo) {
		signService.updateSignLevel3(signImg, documentNo);
	}
}
