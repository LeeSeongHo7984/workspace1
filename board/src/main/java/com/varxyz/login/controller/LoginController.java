package com.varxyz.login.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.login.service.LoginService;
import com.varxyz.login.serviceImpl.LoginServiceImpl;
import com.varxyz.user.domain.User;

@Controller
public class LoginController {
	
	LoginService loginService = new LoginServiceImpl();
	
	// 로그인 화면
	@GetMapping("/login")
	public String loginForm(HttpSession session) {
		
		// 세션 끊기
		session.invalidate();
		
		return "login/login";
	}
	
	// 로그인시 화면 넘어가기
	@PostMapping("/login")
	public String login(User user, HttpSession session, HttpServletRequest request) {
		
		User dbUser = new User();
		dbUser = loginService.login(user.getUserId());
		
		if(user.getUserId().equals(dbUser.getUserId()) && user.getPasswd().equals(dbUser.getPasswd())) {

			session.setAttribute("userId", dbUser.getUserId());
			
			return "redirect:/readBoard";
		}

		request.setAttribute("msg", "아이디 또는 비밀번호를 다시 확인해 주세요!!");
		
		return "alert/alert";
		
	}

	
	
}
