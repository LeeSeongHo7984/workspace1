package com.varxyz.javacafe.serviceImpl;

import com.varxyz.javacafe.dto.Menu;
import com.varxyz.javacafe.service.MenuService;

public class MenuServiceImpl implements MenuService {
	
	@Override
	public void addMenu(Menu menu) {
		menuDao.addMenu(menu);
	}
}
