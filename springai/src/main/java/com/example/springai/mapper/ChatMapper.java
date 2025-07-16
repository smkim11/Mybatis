package com.example.springai.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.springai.dto.ChatHistory;

@Mapper
public interface ChatMapper {
	void saveChat(ChatHistory chatHistory);
}
