package com.varxyz.banking.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.banking.jdbc.DataSourceConfig;
import com.varxyz.banking.mvc.dao.LoginDao;
import com.varxyz.banking.mvc.dto.Customer;

public interface LoginService {
	AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	LoginDao loginDao = context.getBean("loginDao", LoginDao.class);
	
	public Customer login(String x);
}
