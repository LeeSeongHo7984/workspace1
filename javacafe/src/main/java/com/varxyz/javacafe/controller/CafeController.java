package com.varxyz.javacafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.javacafe.dto.Category;
import com.varxyz.javacafe.dto.Menu;
import com.varxyz.javacafe.service.CategoryService;
import com.varxyz.javacafe.service.MenuService;
import com.varxyz.javacafe.serviceImpl.CategoryServiceImpl;
import com.varxyz.javacafe.serviceImpl.MenuServiceImpl;

@Controller("controller.CafeController") // 빈에게 등록하라고 적어줌
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

//	----------- 메뉴 영역 ---------------
	
	// 메뉴 추가 및 수정화면
	@GetMapping("/auMenu")
	public String auMenuFrom() {
		
		return "auMenu/auMenu";
	}
	
	// 메뉴 추가
	@GetMapping("/addMenu")
	public String addMenuForm(Model model) {
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = categoryService.findAllCaList(); // 디비에서 불러와야됨

		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryList);

		return "menu/addMenu/addMenu";
	}

	@PostMapping("/addMenu")
	public String addMenu(Menu menu, HttpServletRequest request, Model model) {
		
		if(menu.getCategoryName() == "unknown") {
			
			model.addAttribute("msg", "카테고리를 선택해 주세요");
			
			return "errorMsg";
		} 
		
		model.addAttribute("menu", menu); 
		menuService.addMenu(menu);
		MenuService.context.close();
		 
		return "menu/addMenu/successAddMenu";
	}
	
	// 메뉴 목록 조회
	@GetMapping("/selectMenu")
	public String selectMenuForm(HttpSession session, Model model) {

		return "menu/select/selectMenu";
	}

	@PostMapping("/selectMenu")
	public String selectMenu(Menu name, HttpSession session, Model model) {
		model.addAttribute("menuList", menuService.selectMenuByCategory(name.getName()));
		MenuService.context.close();

		return "menu/select/successSelectMenu";
	}

	// 메뉴 목록 수정
	@GetMapping("/modifyMenu") 
	public String modifyMenuFrom(String name, Model model) {
		
		List<Menu> menuList = new ArrayList<Menu>();
		
		menuList= menuService.findAllMenuList();
		model.addAttribute("menuList", menuList);
		
		return "modifyMenu/modifyMenu";
	}
	
	@PostMapping("/modifyMenu")
	public String modifyMenu(String afterName, int price, String name) {
		menuService.modifyMenu(afterName, price, name);
		
		return "modifyMenu/scModifyMenu";
	}
	
	// 메뉴 목록 삭제
	@PostMapping("deleteMenu")
	public String deleteMenu(String name) {
		
		menuService.deleteMenu(name);
		
		return "modifyMenu/scDeleteMenu";
	}
	
	// 결제화면
	@GetMapping("/successPayment")
	public String PaymentForm(HttpSession session, Model model) {

		return "payment/successPayment";
	}
	
//	----------- 카테고리 영역 ---------------
	
	// 카테고리 추가
	@GetMapping("/auCategory")
	public String auCategoryForm() {
		
		return "auCategory/auCategory";
	}

	// 카테고리 추가
	@GetMapping("/addCategory") // 여기는 내가 지정하고 싶은 url 주소
	public String addCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		return "category/add/addCategory"; // jsp 경로
	}

	@PostMapping("/success") // jsp에 action값이랑 맞춰야 한다
	public String addCategory(Category category, Model model) {
		
		try {
			if(category.getName() == null || category.getName() == "") {
				model.addAttribute("msg", "카테고리를 입력해주세요");
				
				return "errorMsg";
			}
		} catch (IllegalStateException e) {
			if(categoryService.findAllCaList().size() > 0) {
			model.addAttribute("msg", "이미 존재하는 카테고리 입니다");
			
			return "errorMsg";
			}
		}
		
		model.addAttribute("category", category);
		categoryService.addCategory(category);

		return "category/add/successCategory"; // jsp 경로

}

	// 카테고리 목록 조회
	@GetMapping("/inquiryCategory")
	public String findAllCaList(Model model) {
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = categoryService.findAllCaList(); // 디비에서 불러와야됨

		model.addAttribute("categoryList", categoryList);
		return "category/inquiry/inquiryCategory";
	}

	@PostMapping("/selectCategory")
	public String findAllMenuList(Category category, HttpServletRequest request, HttpSession session, Model model) {
		List<Menu> menuList = new ArrayList<Menu>();
		List<Category> categoryList = new ArrayList<Category>();
		System.out.println("카테고리 리스트 값 : " +  categoryList);
		menuList = menuService.findAllMenuListByCn(category.getName());

		try {
			if(!category.getName().equals("unknown")) {
				session.setAttribute("categoryName", category.getName());
				System.out.println(category.getName()); // 결과 : 선택한 카테고리의 이름
				
				model.addAttribute("menuList", menuList);
				System.out.println(menuList.get(0).getName()); // 결과 : 메뉴 이름
				
				CategoryService.context.close();
				
				return "menu/select/selectMenu";
			}
		} catch (Exception e) {
			if(categoryList.size() == 0) {
			model.addAttribute("msg", "죄송합니다, 준비중인 상품입니다");
			
			return "errorMsg";
			}
		}
		
		model.addAttribute("msg", "카테고리를 선택해 주세요");
		
		return "errorMsg";
	}
	
	// 카테고리 선택 및 수정
	@GetMapping("/modifyCategory")
	public String updateCategoryForm(Model model) {
		
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = categoryService.findAllCaList();
		
		model.addAttribute("categoryList", categoryList);
		
		return "modifyCategory/modifyCategory";
	}
	
	@PostMapping("/modifyCategory")
	public String  modifyCategory(String afterName, String name) {
		System.out.println(afterName);	// 바뀌고 난 후 카테고리명
		System.out.println(name);	// 기존 카테고리명
		categoryService.modifyCategory(afterName,  name);	
		
		return "modifyCategory/scModifyCategory";
	}
	
	// 카테고리 삭제
	@PostMapping("/deleteCategory")
	public String deleteCategory(String name) {
		categoryService.deleteCategory(name);
		
		return "modifyCategory/scDeleteCategory";
	}

}