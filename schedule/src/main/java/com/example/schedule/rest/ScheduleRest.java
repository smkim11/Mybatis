package com.example.schedule.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.schedule.service.ILoginService;

@RestController
public class ScheduleRest {
	@Autowired ILoginService loginService;
	
	@GetMapping("/pwUse/{id}/{pw}")
	public String pwUse(@PathVariable String id, @PathVariable String pw) {
		if(loginService.selectId(id, pw) == null) {
			return "pos";
		}
		return "impos";
	}
}
