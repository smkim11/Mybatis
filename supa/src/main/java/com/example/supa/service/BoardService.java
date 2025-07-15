package com.example.supa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.supa.dto.Board;
import com.example.supa.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {
	private BoardMapper boardMapper;
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper=boardMapper;
	}
	
	public List<Board> selectBoard() {
		return boardMapper.selectBoard();
	}
	
	public Board selectBoardById(int id) {
		return boardMapper.selectBoardById(id);
	}
	
	public void insertBoard(Board board) {
		boardMapper.insertBoard(board);
	}
	
	public void editBoard(Board board) {
		boardMapper.editBoard(board);
	}
	
	public void deleteBoard(int id) {
		boardMapper.deleteBoard(id);
	}
}
