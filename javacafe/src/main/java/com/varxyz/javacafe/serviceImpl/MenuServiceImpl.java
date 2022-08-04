package com.varxyz.javacafe.serviceImpl;

import java.util.List;

import com.varxyz.javacafe.dto.Menu;
import com.varxyz.javacafe.service.MenuService;

public class MenuServiceImpl implements MenuService {
	
	@Override
	public void addMenu(Menu menu) {
		menuDao.addMenu(menu);
	}
	
	// 메뉴 리스트
	public List<Menu> findAllMenuList(String categoryName) {
		return menuDao.findAllMenuList(categoryName);
	}

	@Override
	public List<Menu> selectMenuByCategory(String name) {
		return menuDao.selectMenuByCategory(name);
	}
	
}
