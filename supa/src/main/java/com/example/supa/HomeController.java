package com.example.supa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@Autowired NowMapper nowMapper;
	
	@GetMapping("/")
	public String home() {
		
		return nowMapper.selectNow();
	}
}