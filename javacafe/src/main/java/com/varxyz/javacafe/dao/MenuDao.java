package com.varxyz.javacafe.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

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
	public List<Menu> findAllMenuListByCn(String categoryName) {
		String sql = "SELECT * FROM Menu WHERE categoryName = ?";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Menu>(Menu.class), categoryName);
	}
	
	// 메뉴 이름 목록
	public List<Menu> selectMenuByCategory(String name) {
		String sql = "SELECT * FROM Menu WHERE name = ?";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Menu>(Menu.class), name);
	}
	
	// 카테고리 구분 없이 모든 메뉴만 검색
		public List<Menu> findAllMenuList() {
			String sql = "SELECT * FROM Menu";
			
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Menu>(Menu.class));
		}

	// 메뉴 수정
	public void modifyMenu(String afterName, int price, String name) {
		String sql = "UPDATE Menu SET name = ?, price = ? WHERE name = ?";
		
		jdbcTemplate.update(sql, afterName, price, name);
	}

	// 메뉴 삭제
	public void deleteMenu(String name) {
		String sql = "DELETE FROM Menu WHERE name = ?";
		
		jdbcTemplate.update(sql, name);
	}
	
	
}
