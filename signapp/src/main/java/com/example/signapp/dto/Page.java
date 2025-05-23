package com.example.signapp.dto;

import lombok.Data;

@Data
public class Page {
	private int currentPage;
	private int rowPerPage;
	private int beginRow;
	private int totalPage;
	
	public Page(int currentPage, int rowPerPage, int totalPage) {
		this.currentPage = currentPage;
		this.rowPerPage = rowPerPage;
		this.totalPage = totalPage;
		this.beginRow = (currentPage-1) * rowPerPage;
	}
	
	
	public int getLastPage() {
		int lastPage = this.totalPage / this.rowPerPage;
		if(this.totalPage % this.rowPerPage != 0) {
			lastPage++;
		}
		return lastPage;
	}
}
