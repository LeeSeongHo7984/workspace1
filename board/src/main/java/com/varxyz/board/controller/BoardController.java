package com.varxyz.board.controller;

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
import com.varxyz.login.service.LoginService;
import com.varxyz.login.serviceImpl.LoginServiceImpl;
import com.varxyz.user.domain.User;
import com.varxyz.user.service.UserService;
import com.varxyz.user.service.UserServiceImpl;

@Controller
public class BoardController {
	
	LoginService loginService = new LoginServiceImpl();
	UserService userService = new UserServiceImpl();
	BoardService boardService = new BoardServiceImpl();
	
	// 모든 게시글 조회
	@GetMapping("/readBoard")
	public String readBoardForm(Model model, HttpSession session) {
		
//		String userId = (String)session.getAttribute("userId");

		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("boardList", boardService.allReadBoard());
		
		return "board/readBoard";
	}
	
	// readBoard에서 글쓰기 버튼 누르면 넘어가는 페이지
	@PostMapping("/readBoard")
	public String readBoardForm(HttpSession session, HttpServletRequest request) {
		
		String userId = (String)session.getAttribute("userId");
		
		if(userId == null) {
			
			request.setAttribute("msg", "로그인이 필요합니다!!!");
			
			return "/alert/alert";
		}
		
		return "redirect:/addBoard";
	}
	
	// 게시판 등록 페이지
	@GetMapping("/addBoard")
	public String addBoardForm() {
		
		return "board/addBoard";
	}
	
	// 게시글 등록
	@PostMapping("/addBoard")
	public String addBoard(Board board, HttpServletRequest request) {
		
		boardService.addBoard(board);
		
		return "redirect:/readBoard";
	}
	
	//게시글 수정 (기존 게시글 가져오기)
	@GetMapping("/modifyBoard")
	// @RequestParam("num")은 도메인에서 눌렀을때 가져온 데이터 이름이고 String num은 가져온 데이터를 담을 변수
	public String modifyBoardForm(@RequestParam("num") String num, Model model) {
		
		model.addAttribute("boardList", boardService.selectBoard(num));
				
		return "board/modifyBoard";
	}
	
	// 게시글 수정
	@PostMapping("/modifyBoard")
	public String modifyBoard(Board board, HttpServletRequest request) {
		
		board.setNum(request.getParameter("num"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		boardService.modifyBoard(board);
		
		return "redirect:/readBoard";
	}
	
	// 게시글 삭제
	@PostMapping("/deleteBoard")
	public String deleteBoard(String num) {
		
		boardService.deleteBoard(num);
		
		return "redirect:/readBoard";
	}
	
	
}
