package com.example.schedule.service;

import java.util.List;

import com.example.schedule.dto.LoginHistory;
import com.example.schedule.dto.Member;

public interface ILoginService{
	Member login(Member member);
	List<LoginHistory> history();
	void insertLoginHistory(Member member);
	List<LoginHistory> selectIdByDate();
	void updateActive(Member member);
	String selectEmailById(String id);
}
