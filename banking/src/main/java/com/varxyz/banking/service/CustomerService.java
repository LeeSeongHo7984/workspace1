package com.varxyz.banking.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.banking.jdbc.DataSourceConfig;
import com.varxyz.banking.mvc.dao.CustomerDao;
import com.varxyz.banking.mvc.dto.Customer;

public interface CustomerService {	// interface는 객체 생성 못함
	AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	CustomerDao customerDao = context.getBean("customerDao", CustomerDao.class);
	
	public void addCustomer(Customer customer);

}
