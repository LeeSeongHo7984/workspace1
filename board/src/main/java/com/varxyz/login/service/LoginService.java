package com.varxyz.login.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.varxyz.board.data.DataSourceConfig;
import com.varxyz.login.dao.LoginDao;
import com.varxyz.user.domain.User;

@Service
	public interface LoginService {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		LoginDao loginDao = context.getBean("loginDao", LoginDao.class);
	
		
		// 로그인
		public User login(String userId);
		
}
