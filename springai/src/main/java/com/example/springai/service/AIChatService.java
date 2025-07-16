package com.example.springai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import com.example.springai.dto.ChatHistory;
import com.example.springai.mapper.ChatMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class AIChatService {
	// 대화형 AI 모델
	private OpenAiChatModel openAiChatModel;
	private ChatMapper chatMapper;
	
	public AIChatService(OpenAiChatModel openAiChatModel,ChatMapper chatMapper) {
		this.openAiChatModel = openAiChatModel;
		this.chatMapper = chatMapper;
	}
	
	public void saveChat(ChatHistory chatHistory) {
		chatMapper.saveChat(chatHistory);
	}
	
	// OpenAI서버와 통신할 메소드 선언
	// param String userMsg : 사용자 문자열 메세지
	// return String : 챗서버의 응답문자열
	public String generate(String userMsg, HttpSession session) {
		// DB에 저장될 내용 userMsg, session.getId() , aiReply
		// ex) 1, sessionId, 안녕, 그래 안녕
		
		List<Message> messageList = (List<Message>)session.getAttribute("chatHitory");
		
		if(messageList == null) {
			messageList = new ArrayList<>(); // 이전 이력없이 처음하는 대화이면
		}
		
		
		// 챗봇의 답변스타일을 지정
		SystemMessage systemMessage = new SystemMessage("너는 한국어로 반말로만 답변하는 스타일의 AI 챗봇이다.");
		// 사용자 메세지
		UserMessage userMessage = new UserMessage(userMsg);
		
		// List<Object> messageList = List.of(userMessage,systemMessage);
	    messageList.add(userMessage);
	    messageList.add(systemMessage);
	    
		// 옵션
	    OpenAiChatOptions options = OpenAiChatOptions.builder()
	            .model("gpt-3.5-turbo") // 사용하고자 하는 OpenAI 모델(버전)의 이름을 지정
	            .temperature(0.7) // 창의성(무작위성) 정도를 설정(0.0 ~ 2.0)값으로 보통 0~1 사이 사용
	            .build();
	    
	    // OpenAI서버에 전달되는 모델 객체(매개값)
	    Prompt prompt = new Prompt(messageList,options);
		
	    // openAiChatModel빈을 통해 Prompt를 OpenAI서버에 전달
	    ChatResponse res = this.openAiChatModel.call(prompt);
	    String aiReply = res.getResult().getOutput().getText();
	    
	    // ai가 응답한 응답들도 messageList에 누적
	    AssistantMessage assistantMessage = new AssistantMessage(aiReply);
	    messageList.add(assistantMessage);
	    
	    // messageList 변경된 내용을 session의 messageList속성에도 반영
	    session.setAttribute("chatHistory", messageList); // 이전 session chatHistory 속성값을 덮어쓰기
	    
		return aiReply;
	}
}
