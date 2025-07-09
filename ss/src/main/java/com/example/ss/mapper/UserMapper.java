package com.example.ss.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.ss.domain.UserDetailDomain;
import com.example.ss.domain.UserDomain;

@Mapper
public interface UserMapper {
	// 로그인
	UserDomain selectByUsername(String username);
	// 회원조회
	UserDetailDomain selectUser(String username);
	// 회원가입
	int insertUser(UserDomain userDomain);
	int insertUserDetail(UserDetailDomain userDetailDomain);
	// 회원탈퇴
	void deleteUserDetail(String username);
	void deleteUser(String username);
	// 회원수정
	void update(UserDetailDomain UserDetailDomain);
}
