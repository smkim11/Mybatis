package com.example.vrs.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Data;

@Data
public class CustomOAuth2User implements OAuth2User{ // OAuth2UserService가 반환할 DTO
	
	private Map<String,Object> attributes; // service에서 attributes 값 주입(setter,constructor)
	private String role;
	public CustomOAuth2User(Map<String,Object> attributes, String role) {
		this.attributes =attributes;
		this.role = role;
	}
	
	@Override
	public Map<String, Object> getAttributes() {
		
		return this.attributes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> roleList = new ArrayList<>();
		roleList.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				
				return CustomOAuth2User.this.role;
			}
		});
		return roleList;
	}

	@Override
	public String getName() { // attributes속성중에 유니크한 값 사용 - email, mobile
		
		return (String)((Map<String,Object>)this.attributes.get("response")).get("mobile");
	}

}
