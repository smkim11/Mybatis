package com.example.signapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.signapp.dto.Document;
import com.example.signapp.dto.Employee;
import com.example.signapp.dto.Page;
import com.example.signapp.dto.SignForm;

@Mapper
public interface SignMapper {
	void signUp(Employee employee);
	void addSign(SignForm signForm);
	String searchId(String id);
	Employee login(Employee employee);
	List<Document> documentList(Page page);
	int documentCount();
	Document documentOne(int documentNo);
	void updateSignLevel2(String signImg, String documentNo);
	void updateSignLevel3(String signImg, String documentNo);
	void insertDocument(Document document);
	void updateDocument(Document document);
	void deleteDocument(int documentNo);
	String searchPw(String writer);
}
