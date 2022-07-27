package com.varxyz.jvx330.mvc.example2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestMappingController {
	
	@RequestMapping(value="/example2/mapping", method = RequestMethod.GET)	// value는 새로 설정한 주소
	public String getMapping() {
		return "example2/mapping_result";	// 원래 주소
	}
	
	@RequestMapping(value="/example2/mapping", method = RequestMethod.POST) 
	public ModelAndView postMapping() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example2/mapping_result");
		mav.addObject("result", "post 요청의 결과 메세지");
		
		return mav;
	}
}
