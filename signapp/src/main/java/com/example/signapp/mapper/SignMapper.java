package com.example.signapp.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.signapp.dto.Employee;
import com.example.signapp.dto.SignForm;

@Mapper
public interface SignMapper {
	void signUp(Employee employee);
	void addSign(SignForm signForm);
	String searchId(String id);
}
