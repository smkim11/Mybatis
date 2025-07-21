package com.example.hashtag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hashtag.service.MyService;

@Controller
public class MyController {
	private MyService myService;
	public MyController(MyService myService) {
		this.myService=myService;
	}
	
	// 태그포함 리스트 출력
	@GetMapping("/")
	public String boardList(Model model) {
		model.addAttribute("boardList",myService.selectBoardListAndTags());
		return "boardList";
	}
	
	// 태그 추가
	@GetMapping("/addTag")
	public String addTag(Model model,@RequestParam int boardNo) {
		String tags = myService.getTagsByBoard(boardNo);
		System.out.println(tags);
		
		model.addAttribute("tags",tags);
		model.addAttribute("boardNo",boardNo);
		return "addTag";
	}
	
	@PostMapping("/addTag")
	public String addTag(@RequestParam String tags, @RequestParam int boardNo) {
		myService.addTags(tags,boardNo);
		
		return "redirect:/";
	}
}
