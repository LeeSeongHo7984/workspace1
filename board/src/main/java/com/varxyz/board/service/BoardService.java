package com.varxyz.board.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.varxyz.board.dao.BoardDao;
import com.varxyz.board.data.DataSourceConfig;
import com.varxyz.board.domain.Board;

@Service
public interface BoardService {

	AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	BoardDao boardDao = context.getBean("boardDao", BoardDao.class);

	// 게시글 추가
	public void addBoard(Board board);

	// 게시글 조회
	public List<Board> allReadBoard();

	// 번호로 게시글 가져오기
	public List<Board> selectBoard(String num);
	
	// 게시글 수정
	public void modifyBoard(Board board);
	
	// 게시글 삭제
	public void deleteBoard(String num);
	
}
