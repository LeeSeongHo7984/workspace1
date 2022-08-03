package com.varxyz.javacafe.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.javacafe.dao.MenuDao;
import com.varxyz.javacafe.dto.Menu;
import com.varxyz.javacafe.jdbc.DataSourceConfig;

public interface MenuService {
	AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	MenuDao menuDao = context.getBean("menuDao", MenuDao.class);
	
	public void addMenu(Menu menu);
}
