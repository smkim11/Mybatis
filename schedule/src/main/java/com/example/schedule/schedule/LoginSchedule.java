package com.example.schedule.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.schedule.dto.LoginHistory;
import com.example.schedule.dto.Member;
import com.example.schedule.service.ILoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginSchedule {
	@Autowired ILoginService loginService;
	@Autowired JavaMailSender javaMailSender;
	
	@Scheduled(cron = "0 3 16 * * *")
	public void LoginSchedule() {
		log.info("휴면계정 변경 실행");
		List<LoginHistory> list = loginService.selectIdByDate();
		
		for(LoginHistory lh : list) {
			Member member = new Member();
			member.setEmail(loginService.selectEmailById(lh.getId()));
			member.setId(lh.getId());
			
			loginService.updateActive(member);
		
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("admin@localhost.com");
			msg.setTo(member.getEmail());
			msg.setSubject("아이디 휴면계정 처리");
			msg.setText("1년간 접속하지 않아 "+member.getId()+" 아이디가 휴면계정 처리되었습니다.");
			
			javaMailSender.send(msg);
		}
	}
}
