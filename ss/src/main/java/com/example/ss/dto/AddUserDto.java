package com.example.ss.dto;

import lombok.Data;

@Data
public class AddUserDto {
	private String username;
	private String password;
	private String phone;
	private String email;
	private String birth;
}
