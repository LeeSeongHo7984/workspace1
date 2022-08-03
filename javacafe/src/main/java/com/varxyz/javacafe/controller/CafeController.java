package com.varxyz.javacafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.javacafe.dto.Category;
import com.varxyz.javacafe.dto.Menu;
import com.varxyz.javacafe.service.CategoryService;
import com.varxyz.javacafe.service.MenuService;
import com.varxyz.javacafe.serviceImpl.CategoryServiceImpl;
import com.varxyz.javacafe.serviceImpl.MenuServiceImpl;

@Controller("controller.CafeController")	 //빈에게 등록하라고 적어줌
public class CafeController {
	
	// MenuService는 interface라서 객체를 못만드니까 
	// MenuService를 상속받은 MenuServiceImpl을 받는다
	MenuService menuService = new MenuServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	
	// 메인 페이지
	@GetMapping("/home/homePage")
	public String homePageForm() {
		return "home/homePage";
	}
	
	// 메뉴 추가 페이지
	@GetMapping("/menu/addMenu/addMenu")
	public String addMenuForm() {
		return "menu/addMenu/addMenu";
	}
	
	@PostMapping("/menu/addMenu/addMenu")
	public String addMenu(Menu menu, Model model) {
		
		model.addAttribute("menu", menu);
		menuService.addMenu(menu);
		MenuService.context.close();
		
		return "menu/addMenu/successAddMenu";
	}
	
	// 카테고리 추가 페이지
	@GetMapping("/addCategory")	// 여기는 내가 지정하고 싶은 url 주소
	public String addCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		
		return "category/add/addCategory";	// jsp 경로
	}

	@PostMapping("/success")	// jsp에 action값이랑 맞춰야 한다
	public String addCategory(Category category, Model model) {
		
		model.addAttribute("category", category);
		categoryService.addCategory(category);
		
		return "category/add/successCategory";	// jsp 경로
	}
	
	//카테고리 리스트 조회
	@GetMapping("/selectCategory")
	public String selectCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		
		return "category/select/selectCategory";
	}
	
	@PostMapping("/selectCategory")
	public String selectCategory(Category name, HttpSession session, Model model) {
		List<Category> categoryList = new ArrayList<Category>();
		
		categoryList = categoryService.findAllCaList(name);
		model.addAttribute("category", categoryList);
		CategoryService.context.close();
		
		return "category/select/successCategory";
	}
	
}


