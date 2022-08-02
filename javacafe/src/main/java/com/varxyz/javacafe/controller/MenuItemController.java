package com.varxyz.javacafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.javacafe.dto.MenuCommand;

@Controller("controller.menuItemController")	//빈에게 등록하라고 적어줌
@RequestMapping("/controller/menu")
public class MenuItemController {
	
	// 메뉴 추가
	@GetMapping
	public String addMenuForm(Model model) {
		model.addAttribute("menu", new MenuCommand());
	}
}
