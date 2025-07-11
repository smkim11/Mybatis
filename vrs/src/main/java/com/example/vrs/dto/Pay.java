package com.example.vrs.dto;

import lombok.Data;

@Data
public class Pay {
	private int payNo;
	private int reservationNo;
	private int amount;
	private String payMethod;
	private String createdate;
}
