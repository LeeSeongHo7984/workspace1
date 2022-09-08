package com.varxyz.board.serviceImpl;

import org.springframework.stereotype.Component;

import com.varxyz.board.domain.Board;
import com.varxyz.board.service.BoardService;

@Component("boardService")
public class BoardServiceImpl implements BoardService {

	// 게시글 생성
	@Override
	public void addBoard(Board board) {
		boardDao.addBoard(board);
	}
	
}
