package com.example.vrs.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vrs.dto.Pay;
import com.example.vrs.dto.Reservation;
import com.example.vrs.mapper.ReservationMapper;

@Service
@Transactional
public class ReservationService {
	private ReservationMapper reservationMapper;
	public ReservationService(ReservationMapper reservationMapper) {
		this.reservationMapper = reservationMapper;
	}
	
	// 날짜와 시간별 예약가능여부 포함한 테이블리스트
	public List<HashMap<String,Object>> roomList(Reservation reservation){
		return reservationMapper.roomList(reservation);
	}
	
	// 예약한 예약번호 찾기
	public int selectReservationNo(Reservation reservation) {
		return reservationMapper.selectReservationNo(reservation);
	}
	
	// 예약하기
	public void insertReservation(Reservation reservation) {
		reservationMapper.insertReservation(reservation);
	}
	
	// 예약금 결제
	public void insertPay(Pay pay) {
		reservationMapper.insertPay(pay);
	}
}
