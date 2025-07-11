package com.example.vrs.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vrs.dto.Reservation;
import com.example.vrs.service.ReservationService;

@Controller
public class HomeController {
	private ReservationService reservationService;
	public HomeController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping("/")
	public String home(Model model,@RequestParam(required = false) String reservationDate
								  ,@RequestParam(required = false) String reservationOption) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// authentication(인증된 UserDetails DTO getName)
		String name= authentication.getName();
		
		// authentication(인증된 UserDetails DTO getRole)
		Collection<? extends GrantedAuthority> roleList =  authentication.getAuthorities();
		// 순서가 있는(foreach가능한) 컬랙션으로 변경(Iterator)
		Iterator<? extends GrantedAuthority> iterator = roleList.iterator();
		
		GrantedAuthority gh = null;
		String role="";
		/* 하나의 roll만 설정되어있어서 반복문을 돌릴 필요없다. (여러값받을때 사용)
		while((gh=iterator.next()) != null) {
			String role = gh.getAuthority();
		}
		*/
		
		if((gh=iterator.next()) != null) {
			role = gh.getAuthority();
		}
		Reservation reservation = new Reservation();
		if(reservationDate != null && reservationOption != null) {
			reservation.setReservationDate(reservationDate);
			reservation.setReservationOption(reservationOption);
			
			List<HashMap<String,Object>> list = reservationService.roomList(reservation);
			System.out.println("테이블:"+list);
			
			model.addAttribute("date",reservationDate);
			model.addAttribute("option",reservationOption);
			model.addAttribute("reservationList",list);
		}
		
		model.addAttribute("name", name);
		model.addAttribute("role",role);
		return "home";
	}
	
	
}
