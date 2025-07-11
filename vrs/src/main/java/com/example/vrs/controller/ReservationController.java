package com.example.vrs.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.vrs.dto.Pay;
import com.example.vrs.dto.Reservation;
import com.example.vrs.service.ReservationService;

@Controller
public class ReservationController {
	private ReservationService reservationService;
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	// 날짜와 시간으로 테이블 검색
	@PostMapping("/searchTable")
	public String searchTable(Reservation reservation,RedirectAttributes redirectAttributes) {
		
		
		redirectAttributes.addAttribute("reservationDate", reservation.getReservationDate());
		redirectAttributes.addAttribute("reservationOption", reservation.getReservationOption());
		return "redirect:/";
	}
	
	// 예약하기
	@GetMapping("/reservation")
	public String reservation(Model model,@RequestParam int roomNo, @RequestParam int roomLimit,
							  @RequestParam String date, @RequestParam String option) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// authentication(인증된 UserDetails DTO getName)
		String mobile= authentication.getName();
		
		// authentication(인증된 UserDetails DTO getRole)
		Collection<? extends GrantedAuthority> roleList =  authentication.getAuthorities();
		// 순서가 있는(foreach가능한) 컬랙션으로 변경(Iterator)
		Iterator<? extends GrantedAuthority> iterator = roleList.iterator();
		
		GrantedAuthority gh = null;
		String role="";
		
		if((gh=iterator.next()) != null) {
			role = gh.getAuthority();
		}
		Reservation reservation = new Reservation();
		reservation.setRoomNo(roomNo);
		reservation.setProvider(role);
		reservation.setReservationId(mobile);
		reservation.setReservationDate(date);
		reservation.setReservationOption(option);
		
		model.addAttribute("limit",roomLimit);
		model.addAttribute("reservation",reservation);
		return "reservation";
	}
	
	@PostMapping("/reservation")
	public String reservation(RedirectAttributes redirectAttributes, Reservation reservation) {
		reservation.setProvider(reservation.getProvider().substring(5).toLowerCase());
		reservationService.insertReservation(reservation);
		
		int reservationNo=reservationService.selectReservationNo(reservation);
		
		redirectAttributes.addAttribute("reservationNo", reservationNo);
		return "redirect:/pay";
	}
	
	// 예약금 결제
	@GetMapping("/pay")
	public String pay(Model model,@RequestParam int reservationNo) {
		
		model.addAttribute("reservationNo",reservationNo);
		return "pay";
	}
	
	@PostMapping("/pay")
	public String pay(Pay pay) {
		
		reservationService.insertPay(pay);
		return "redirect:/";
	}
}
