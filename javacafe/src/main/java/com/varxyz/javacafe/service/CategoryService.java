package com.varxyz.javacafe.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.javacafe.dao.CategoryDao;
import com.varxyz.javacafe.dto.Category;
import com.varxyz.javacafe.jdbc.DataSourceConfig;

public interface CategoryService {
	AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	CategoryDao categoryDao = context.getBean("categoryDao", CategoryDao.class);
	
	// 카테고리 추가
	public void addCategory(Category category);
	
	// 카테고리 목록 보기
	public List<Category> findAllCaList(Category name);
}
