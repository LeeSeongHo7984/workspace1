package com.varxyz.banking.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.banking.jdbc.DataSourceConfig;
import com.varxyz.banking.mvc.dao.AccountDao;
import com.varxyz.banking.mvc.dto.Account;

public interface AccountService { // interface는 객체 생성 못함
	AnnotationConfigApplicationContext context = 
		new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
	
	public void addAccount(Account account);

	List<Account> findAccountsByCustomerId(String customerId);
}
