package com.varxyz.board.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.varxyz.board.dao.BoardDao;
import com.varxyz.board.domain.Board;
import com.varxyz.board.jdbc.DataSourceConfig;

@Component("boardService")
public interface BoardService {
	AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	BoardDao boardDao = context.getBean("boardDao", BoardDao.class);

	public void addBoard(Board board);
	
	
}
