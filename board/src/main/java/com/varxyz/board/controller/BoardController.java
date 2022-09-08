package com.varxyz.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.board.domain.Board;
import com.varxyz.board.service.BoardService;
import com.varxyz.board.serviceImpl.BoardServiceImpl;

@Controller("controller.boardController")
public class BoardController {
	BoardService boardService = new BoardServiceImpl();
	
	// 게시글 생성
	@GetMapping("/addBoard")
	public String addBoardForm() {
		
		return "board/addBoard";
	}
	
	@PostMapping("/addBoard")
	public String addBoard(HttpServletRequest request, Model model) {
		Board board = new Board();
		
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		boardService.addBoard(board);
		
		return "board/readBoard";
	}
	
	
	//게시글 조회
	@GetMapping("/readBoard")
	public String readBoardForm() {
		
		return "/board/readBoard";
	}
	
	@PostMapping("/readBoard")
	public String readBoard() {
		
		return "board/addBoard";
	}
	
	
	//게시글 수정
	@GetMapping("/modifyBoard")
	public String modifyBoardForm() {
		
		return "board/modifyBoard";
	}
	
	
	// 게시글 삭제
	@GetMapping("/deleteBoard")
	public String deleteBoardForm() {
		
		return "board/deleteBoard";
	}
	
}
