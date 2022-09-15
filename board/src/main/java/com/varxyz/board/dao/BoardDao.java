package com.varxyz.board.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.varxyz.board.domain.Board;

@Repository
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
	public List<Board> allReadBoard() {
		String sql = "SELECT * FROM Board";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Board>(Board.class));
	}
	
	// 번호로 게시글 조회
	public List<Board> selectBoard(String num) {
		String sql = "SELECT * FROM Board WHERE num = ?";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Board>(Board.class), num);
	}	

	// 게시글 수정
	public void modifyBoard(Board board) {
		String sql = "UPDATE Board SET title = ?, content = ? WHERE num = ?";
		
		jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getNum());
	}

	// 게시글 삭제
	public void deleteBoard(String num) {
		String sql = "DELETE FROM BOARD WHERE num = ?";

		jdbcTemplate.update(sql, num);
	}
	
}
