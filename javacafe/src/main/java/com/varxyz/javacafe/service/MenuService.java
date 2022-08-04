package com.varxyz.javacafe.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.javacafe.dao.MenuDao;
import com.varxyz.javacafe.dto.Category;
import com.varxyz.javacafe.dto.Menu;
import com.varxyz.javacafe.jdbc.DataSourceConfig;

public interface MenuService {
	AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	MenuDao menuDao = context.getBean("menuDao", MenuDao.class);
	
	// 메뉴 추가
	public void addMenu(Menu menu);

	// 메뉴 리스트
	public List<Menu> findAllMenuList(String categoryName);
	
	//메뉴 선택
	public List<Menu> selectMenuByCategory(String name);

	
}
