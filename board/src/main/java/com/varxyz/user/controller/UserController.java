package com.varxyz.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.user.domain.User;
import com.varxyz.user.service.UserService;
import com.varxyz.user.service.UserServiceImpl;

@Controller
public class UserController {

	UserService userService = new UserServiceImpl();
	
	// 회원가입
	@GetMapping("/addUser")
	public String addUserForm() {
		
		return "user/addUser";
	}
	
	@PostMapping("/addUser")
	public String addUser(User user) {
		
		userService.addUser(user);
		
		return "redirect:/login";
	}
	
	// 회원 정보
	@GetMapping("/readUser") 
	public String readUser(Model model) {
		
		model.addAttribute("userList", userService.readUser("userId"));
		
		return "user/userRead";
	}
	
	
}
