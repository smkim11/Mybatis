package com.example.springai.dto;

import lombok.Data;

@Data
public class ChatHistory {
	private int chatNo;
	private String id;
	private String userChat;
	private String aiChat;
}
