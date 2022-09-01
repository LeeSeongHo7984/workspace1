package com.varxyz.jvx330.mvc.example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/example1/sayHello")	// 아무것도 안적으면 get방식
	public ModelAndView sayHello() {
		String greeting = "Hello! 스프링 MVC";
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("example1/hello");	// jsp파일 이름
		mav.addObject("greeting", greeting);	//앞에 "greeting"속성명, gretting는 속성값
		
		return mav;
	}


}
