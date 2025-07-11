package com.example.vrs.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vrs.dto.Pay;
import com.example.vrs.dto.Reservation;

@Mapper
public interface ReservationMapper {
	List<HashMap<String,Object>> roomList(Reservation reservation);
	void insertReservation(Reservation reservation);
	int selectReservationNo(Reservation reservation);
	void insertPay(Pay pay);
}
