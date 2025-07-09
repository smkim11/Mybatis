package com.example.ss.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ss.domain.UserDetailDomain;
import com.example.ss.domain.UserDomain;
import com.example.ss.dto.AddUserDto;
import com.example.ss.mapper.UserMapper;

@Service
@Transactional
public class UserService {
	private UserMapper userMapper;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserMapper userMapper,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userMapper = userMapper;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	// 회원정보조회
	public UserDomain selectByUsername(String username) {
		return userMapper.selectByUsername(username);
	}
	
	// 회원상세정보조회
	public UserDetailDomain selectUser(String username) {
		
		return userMapper.selectUser(username);
	}
	
	// 회원 가입
	public void addUser(AddUserDto addUserDto) {
		if(userMapper.selectByUsername(addUserDto.getUsername()) == null) {
			// dto -> domain
			UserDomain userDomain = new UserDomain();
			userDomain.setUsername(addUserDto.getUsername());
			userDomain.setRole("ROLE_USER"); // ROLE_ADMIN, ROLE_USER
			userDomain.setPassword(bCryptPasswordEncoder.encode(addUserDto.getPassword()));
			
			UserDetailDomain userDetailDomain = new UserDetailDomain();
			userDetailDomain.setUsername(addUserDto.getUsername());
			userDetailDomain.setPhone(addUserDto.getPhone());
			userDetailDomain.setEmail(addUserDto.getEmail());
			userDetailDomain.setBirth(addUserDto.getBirth());
			
			userMapper.insertUser(userDomain);
			userMapper.insertUserDetail(userDetailDomain);
		}else {
			System.out.println(addUserDto.getUsername()+"는 이미 존재합니다.");
			// throw new RuntimeException("이름이 이미 존재합니다.");
		}	
	}
	
	// 회원수정
	public void update(UserDetailDomain UserDetailDomain) {
		userMapper.update(UserDetailDomain);
	}
	
	// 회원삭제
	public void delete(String username) {
		userMapper.deleteUserDetail(username);
		userMapper.deleteUser(username);
	}
}
