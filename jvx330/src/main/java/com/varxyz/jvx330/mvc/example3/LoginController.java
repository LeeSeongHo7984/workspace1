package com.varxyz.jvx330.mvc.example3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("example3.LoginController")	// example3에 있는 LoginController 이다 
public class LoginController {
	
	@GetMapping("/example3/login")
	public String loginForm() {
		return "example3/login";
	}
	
//	@PostMapping("/example3/login")
	public ModelAndView login(HttpServletRequest request) {	// 값 넣어주면 getParameter로 내가 찾는다리
		String userId = request.getParameter("userId");	// 아이디 받아오기
		String passwd = request.getParameter("passwd");	// 비밀번호 받아오기
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userI`d", userId);
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result");
		
		return mav;
	}
	
	@PostMapping("/example3/login")	
	// required는 반드시 필요한가 묻는것(기본값은 true) 안쓰면 error가 떨어짐
	// @RequestParam String passwd 형식으로 쓰면됨. 
	// @RequestParam(value="userId", required=true) String id 는 형식을 보여줄려고 이렇게 한거임
	public ModelAndView login(@RequestParam(value="userId", required=true) String id, 
								@RequestParam String passwd) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result");
		
		return mav;
	}
}
