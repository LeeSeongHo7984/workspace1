package com.varxyz.javacafe.serviceImpl;

import java.util.List;

import com.varxyz.javacafe.dto.Category;
import com.varxyz.javacafe.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	// 카테고리 추가
	@Override
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}
	
	// 카테고리 조회
	@Override
	public List<Category> findAllCaList() {
		return categoryDao.findAllCaList();
	}
	
	// 메뉴 목록 선택
	@Override
	public List<Category> selectMenutList(String name) {
		return categoryDao.selectMenutList(name);
	}
}
