package com.example.signapp.dto;

import lombok.Data;

@Data
public class Document {
	private int documentNo;
	private String title;
	private String content;
	private String writer;
}
