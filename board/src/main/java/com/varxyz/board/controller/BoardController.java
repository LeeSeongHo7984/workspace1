package com.varxyz.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.board.domain.Board;
import com.varxyz.board.service.BoardService;
import com.varxyz.board.serviceImpl.BoardServiceImpl;

@Controller
public class BoardController {
	
	BoardService boardService = new BoardServiceImpl();
	
	// 게시글 등록
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
		
		return "redirect:/readBoard";
	}
	
	
	//게시글 조회
	@GetMapping("/readBoard")
	public String readBoardForm(Model model) {
		
		List<Board> boardList = new ArrayList<Board>();
		
		boardList = boardService.allReadBoard();
		
		model.addAttribute("boardList", boardList);
		
		return "board/readBoard";
	}
	
	// readBoard에서 글쓰기 버튼 누르면 넘어가는 페이지
	@PostMapping("/readBoard")
	public String readBoardForm() {
		
		return "redirect:/addBoard";
	}
	
	//게시글 수정 (기존 게시글 가져오기)
	@GetMapping("/modifyBoard")
	public String modifyBoardForm(@RequestParam("num") String num, HttpServletRequest request, Model model) {
		
		model.addAttribute("boardList", boardService.selectBoard(num));
				
		return "board/modifyBoard";
	}
	
	
	@PostMapping("/modifyBoard")
	public String modifyBoard(HttpServletRequest request, Model model) {
		
		Board board = new Board();
		
		board.setNum(request.getParameter("num"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		boardService.modifyBoard(board);
		
		return "redirect:/readBoard";
	}
	
	@PostMapping("/deleteBoard")
	public String deleteBoard(String num, HttpServletRequest request, Model model) {
		
		boardService.deleteBoard(num);
		
		return "redirect:/readBoard";
	}
	
}
