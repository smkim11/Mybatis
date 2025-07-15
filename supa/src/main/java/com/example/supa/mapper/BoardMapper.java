package com.example.supa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.supa.dto.Board;

@Mapper
public interface BoardMapper {
	List<Board> selectBoard();
	Board selectBoardById(int id);
	void insertBoard(Board board);
	void editBoard(Board board);
	void deleteBoard(int id);
}
