package com.varxyz.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@GetMapping("/userInfo") 
	public String userInfo(Model model, HttpSession session) {
		
		List<User> userList = new ArrayList<User>();
		
		userList = userService.readUser((String) session.getAttribute("userId"));

		model.addAttribute("userList", userList);
		
		return "user/userInfo";
	}
	
	// 회원 수정
	@GetMapping("/userModify")
	public String userModify(Model model, HttpSession session) {
		
		List<User> userList = new ArrayList<User>();
		
		userList = userService.readUser((String) session.getAttribute("userId"));
		
		model.addAttribute("userList", userList);
		
		return "user/userModify";
	}
	
	@PostMapping("/userModify")
	public String userModifyForm(User user) {
		
		userService.userModify(user);
		
//		request 방법
//		user.setUserId(request.getParameter("userId"));
//		user.setPasswd(request.getParameter("passwd"));
//		user.setName(request.getParameter("name"));
//		user.setSsn(request.getParameter("ssn"));
//		user.setAddress(request.getParameter("address"));
//		user.setPhone(request.getParameter("phone"));
		
		return "redirect:/readBoard";
	}
	
	
}
