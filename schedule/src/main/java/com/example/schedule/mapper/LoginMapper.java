package com.example.schedule.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.schedule.dto.LoginHistory;
import com.example.schedule.dto.Member;
import com.example.schedule.dto.PwHistory;

@Mapper
public interface LoginMapper {
	Member login(Member member);
	List<LoginHistory> history();
	void insertLoginHistory(Member member);
	List<LoginHistory> selectIdByDate();
	void updateActive(Member member);
	String selectEmailById(String id);
	String selectId(String id, String pw);
	String selectPwById(String id);
	void updatePw(Member member);
	void insertPwHistory(Member member);
	List<PwHistory> findIdList();
	int countId(String id);
	int selectOldNo(String id);
	void deleteOldNo(int no);
}
