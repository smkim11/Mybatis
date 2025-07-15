package com.example.supa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.supa.dto.Board;
import com.example.supa.service.BoardService;

@Controller
public class BoardController {
	private BoardService boardService;
	public BoardController(BoardService boardService) {
		this.boardService=boardService;
	}
	
	// 리스트
	@GetMapping("/boardList")
	public String boardList(Model model) {
		List<Board> list = boardService.selectBoard();
		
		model.addAttribute("list",list);
		return "boardList";
	}
	
	// 추가
	@GetMapping("/addBoard")
	public String addBoard() {
		return "addBoard";
	}
	
	@PostMapping("/addBoard")
	public String addBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:/boardList";
	}
	
	// 수정
	@GetMapping("/editBoard")
	public String editBoard(Model model, @RequestParam int id) {
		model.addAttribute("board",boardService.selectBoardById(id));
		return "editBoard";
	}
	
	@PostMapping("/editBoard")
	public String editBoard(Board board) {
		boardService.editBoard(board);
		return "redirect:/boardList";
	}
	
	// 삭제
	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam int id) {
		boardService.deleteBoard(id);
		return "redirect:/boardList"; 
	}
}
