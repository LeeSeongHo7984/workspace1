package com.varxyz.banking.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.banking.jdbc.DataSourceConfig;
import com.varxyz.banking.mvc.dao.TransferDao;
import com.varxyz.banking.mvc.dto.Account;

public interface TransferService {
	AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	TransferDao transferDao = context.getBean("transferDao", TransferDao.class);

	Account transfer(String deposit, String withdraw, String accountNum);
}
