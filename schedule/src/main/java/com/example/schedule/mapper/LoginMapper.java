package com.example.schedule.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.schedule.dto.LoginHistory;
import com.example.schedule.dto.Member;

@Mapper
public interface LoginMapper {
	Member login(Member member);
	List<LoginHistory> history();
	void insertLoginHistory(Member member);
	List<LoginHistory> selectIdByDate();
	void updateActive(Member member);
	String selectEmailById(String id);
}
