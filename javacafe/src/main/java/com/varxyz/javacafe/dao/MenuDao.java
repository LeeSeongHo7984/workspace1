package com.varxyz.javacafe.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.javacafe.dto.Menu;

@Repository("menuDao")
public class MenuDao {
	private JdbcTemplate jdbcTemplate;
	
	public MenuDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 메뉴 추가
	public void addMenu(Menu menu) {
		String sql = "INSERT INTO Menu (name, price, categoryName) "
					+ "VALUES (?, ?, ?)";
		
		jdbcTemplate.update(sql, menu.getName(), menu.getPrice(), menu.getCategoryName());
	}

	// 메뉴 리스트
	public List<Menu> findAllMenuList(String categoryName) {
		String sql = "SELECT * FROM Menu WHERE categoryName = ?";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Menu>(Menu.class), categoryName);
	}
	
	// 메뉴 이름 목록
	public List<Menu> selectMenuByCategory(String name) {
		String sql = "SELECT * FROM Menu WHERE name = ?";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Menu>(Menu.class), name);
	}
	
	
}
