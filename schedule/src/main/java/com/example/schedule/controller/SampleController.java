package com.example.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.schedule.dto.SampleForm;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	@GetMapping("/addSample")
	public String addSample() {
		return "addSample";
	}
	
	@PostMapping("/addSample")
	public String addSample(@Valid SampleForm sampleForm, Errors errs, Model model) {
		// 커맨드객체 sampleForm이 생성될때 @Valid 유효성 검증이 먼저 선행된다. -> 에러발생시 Errors 객체에 에러정보 추가
		log.info(sampleForm.toString());
		// @Valid 선행작업에서 Errors가 있다면 : 입력값 유효성 검사 후 입력 실패
		if(errs.hasErrors()) {
			for(FieldError fe : errs.getFieldErrors()) {
				model.addAttribute(fe.getField()+"ErrMsg", fe.getDefaultMessage());
				// == model.addAttribute("nameErrMsg", "아이디는 4자이상 10자이하로 입력하셔야 합니다");
			}
			return "addSample";
		}
		
		/* Validation 사용하지 않은 유효성 검사
		if(sampleForm.getName() == null || sampleForm.getName().length()<4 || sampleForm.getAge()<0 || sampleForm.getAge()>200) {
			model.addAttribute("errMsg","입력값 유효성 검증 실패");
			log.info("인증되지않은 POST요청 입니다.");
			return "addSample";
		}
		*/
		return "redirect:/";
	}
}
