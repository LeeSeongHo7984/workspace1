package com.varxyz.javacafe.serviceImpl;

import java.util.List;

import com.varxyz.javacafe.dto.Category;
import com.varxyz.javacafe.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	@Override
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}
	
	@Override
	public List<Category> findAllCaList(Category name) {
		return categoryDao.findAllCaList(name);
	}
}
