package com.example.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.schedule.dto.LoginHistory;
import com.example.schedule.dto.Member;
import com.example.schedule.mapper.LoginMapper;

@Transactional
@Service
public class LoginService implements ILoginService{
	@Autowired LoginMapper loginMapper;
	
	// 로그인
	@Override
	public Member login(Member member) {
		return loginMapper.login(member);
	}
	
	// 로그인 기록 리스트
	@Override
	public List<LoginHistory> history() {
		return loginMapper.history();
	}
	
	// 로그인 시 로그인기록
	@Override
	public void insertLoginHistory(Member member) {
		loginMapper.insertLoginHistory(member);
		
	}
	
	// 1년 넘게 접속하지 않은 아이디
	@Override
	public List<LoginHistory> selectIdByDate() {
		return loginMapper.selectIdByDate();
	}

	// 휴면계정 전환
	@Override
	public void updateActive(Member member) {
		loginMapper.updateActive(member);
	}

	// 아이디에 해당하는 이메일
	@Override
	public String selectEmailById(String id) {
		return loginMapper.selectEmailById(id);
	}
}
