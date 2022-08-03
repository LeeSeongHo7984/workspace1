package com.varxyz.javacafe.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
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
}
