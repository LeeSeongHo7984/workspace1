package com.varxyz.board.serviceImpl;

import java.util.List;

import com.varxyz.board.domain.Board;
import com.varxyz.board.service.BoardService;

public class BoardServiceImpl implements BoardService {
	
	// 게시글 생성
	@Override
	public void addBoard(Board board) {
		boardDao.addBoard(board);
	}

	// 게시글 조회
	@Override
	public List<Board> allReadBoard() {
		
		return boardDao.allReadBoard();
	}

	// 게시글 번호로 게시글 조회
	@Override
	public List<Board> selectBoard(String num) {
		
		System.out.println(2);
		return boardDao.selectBoard(num);
	}
	
	// 게시글 수정
	@Override
	public List<Board> modifyBoard() {
	
		return boardDao.modifyBoard();
	}


	
}
