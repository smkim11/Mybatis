package com.example.springai.api;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springai.dto.ChatHistory;
import com.example.springai.service.AIChatService;

import jakarta.servlet.http.HttpSession;

@RestController
public class AIChatController {
	private final AIChatService aIChatService;
	public AIChatController(AIChatService aIChatService) {
		this.aIChatService = aIChatService;
	}
	
	@PostMapping("/chat")
	public String chat(@RequestBody Map<String,String> body, HttpSession session) { // session 속성안에 message 리스트를 만들어 이전대화를 누적
		// {"":"","":""} JSON 문자열 -> 자바 DTO객체 (@RequestBody가 변경해준다)
		ChatHistory chatHistory = new ChatHistory();
		
		String userMsg = body.get("userMsg");
		String aiReply = aIChatService.generate(userMsg, session);
		
		chatHistory.setId(session.getId());
		chatHistory.setUserChat(userMsg);
		chatHistory.setAiChat(aiReply);
		
		aIChatService.saveChat(chatHistory);
		
		return aiReply;
	}
}
