package com.example.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.schedule.dto.LoginHistory;
import com.example.schedule.dto.Member;
import com.example.schedule.dto.PwHistory;
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
	
	// 비밀번호 사용 이력이 있는지 조회
	@Override
	public String selectId(String id, String pw) {
		return loginMapper.selectId(id, pw);
	}

	// 아이디에 맞는 비밀번호 조회
	@Override
	public String selectPwById(String id) {
		return loginMapper.selectPwById(id);
	}

	// 비밀번호 변경
	@Override
	public void updatePw(Member member) {
		loginMapper.updatePw(member);
	}

	// 비밀번호변경시 기록
	@Override
	public void insertPwHistory(Member member) {
		loginMapper.insertPwHistory(member);
	}

	// 비밀번호 변경 이력이 있는 아이디 조회
	@Override
	public List<PwHistory> findIdList() {
		return loginMapper.findIdList();
	}

	// 비밀번호 변경이력 개수 조회
	@Override
	public int countId(String id) {
		return loginMapper.countId(id);
	}

	// 오래된 변경내역 조회
	@Override
	public int selectOldNo(String id) {
		return loginMapper.selectOldNo(id);
	}

	// 오래된 변경내역 삭제
	@Override
	public void deleteOldNo(int no) {
		loginMapper.deleteOldNo(no);
	}
	
	
}
