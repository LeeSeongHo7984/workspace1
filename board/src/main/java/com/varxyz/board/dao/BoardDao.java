package com.varxyz.board.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.board.domain.Board;

@Repository("boardDao")
public class BoardDao {
	private JdbcTemplate jdbcTemplate;
	
	public BoardDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 게시글 생성
	public void addBoard(Board board) {
		String sql = "INSERT INTO Board (title, content) VALUES (?, ?)";
		
		jdbcTemplate.update(sql, board.getTitle(), board.getContent());
	}
	
	
	// 게시글 조회
	
	
	
	// 게시글 수정
	
	
	
	// 게시글 삭제

}
