package com.varxyz.banking.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.banking.jdbc.DataSourceConfig;
import com.varxyz.banking.mvc.dao.LoginDao;
import com.varxyz.banking.mvc.dto.Customer;

public interface LoginService {
	AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	// ↓ logindao안에 db에 있는 값들을 가져와서 loginDao 객체에 저장
	LoginDao loginDao = context.getBean("loginDao", LoginDao.class);	 
	
	//2. service -> serviceImpl
	public Customer login(String dbId); //db userId
}