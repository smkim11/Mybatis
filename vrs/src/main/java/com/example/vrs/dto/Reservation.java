package com.example.vrs.dto;

import lombok.Data;

@Data
public class Reservation {
	private int reservationNo;
	private int roomNo;
	private String reservationDate;
	private String reservationOption;
	private String reservationName;
	private String reservationId;
	private Integer reservationCount;
	private String provider;
	private String createdate;
	private String updatedate;
}
