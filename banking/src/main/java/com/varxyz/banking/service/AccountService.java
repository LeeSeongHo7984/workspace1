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
	
	// 계좌생성
	public void addAccount(Account account);

	// 고객아이디로 계좌 찾기
	List<Account> findAccountsByCustomerId(String customerId);

	// 입금
	void deposit(String accountNum, double amount);
	
	// 출금
	void withdraw(String accountNum, double amount);
	
	// 잔고 조회
	List<Account> Balance(String accountNum);
}
