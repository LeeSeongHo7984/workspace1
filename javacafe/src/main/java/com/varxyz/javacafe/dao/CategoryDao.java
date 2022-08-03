package com.varxyz.javacafe.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.javacafe.dto.Category;

@Repository("categoryDao")
public class CategoryDao {
	private JdbcTemplate jdbcTemplate;
	
	public CategoryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 카테고리 추가
	public void addCategory(Category category) {
		String sql = "INSERT INTO Category (name) "
					+ "VALUES (?)";
				
		jdbcTemplate.update(sql, category.getName());
	}
	
	// 카테고리 리스트
	public List<Category> findAllCaList(Category name) {
		String sql = "SELECT * FROM Category";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
	}
}

