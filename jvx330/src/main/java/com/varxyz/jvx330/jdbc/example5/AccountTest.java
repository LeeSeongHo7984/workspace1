package com.varxyz.jvx330.jdbc.example5;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Account;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AccountTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Example5Config.class);
		
		AccountDao dao = context.getBean("addAccount", AccountDao.class);
		
//		addAccount(dao);
//		findAccountsBySsn(dao);
//		findAccountsByCustomerId(dao);
		
		context.close();
	}

//	// 계좌 생성 코드
//	private static void addAccount(AccountDao dao) {
//		Account a = new Account();
//		a.setCustomer(1002);
//		a.setAccountNum("987-65-4321");
//		a.setAccType("s");
//		a.setBalance(10.0);
//		a.setInterestRate(20.0);
//		a.setOverAmount(30.0);
//		
//		dao.addAccount(a);
//		System.out.println("- inset -");
//	}
	
	
}
