package com.varxyz.banking.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.mvc.dto.Account;
import com.varxyz.banking.service.AccountService;

@Repository("accountDao")
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 신규 계좌 생성 (addAccount) : 계좌종류, 회원 id 필요
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account (customerId, accountNum, accType, balance, interestRate, overAmount)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
	
		if(account.getAccType() == "S") {
			jdbcTemplate.update(sql, account.getCustomerId(),
					account.getAccountNum(),
					account.getAccType(),
					account.getBalance(),
					account.getInterestRate(),0.0);
		} else {
			jdbcTemplate.update(sql, account.getCustomerId(),
					account.getAccountNum(),
					account.getAccType(),
					account.getBalance(),
					account.getOverAmount(),0.0);
		}
	}
	
	// 자신의 계좌 목록 확인 (getAccount) : 회원 id 필요
		public List<Account> findAccountsByCustomerId(String customerId) {
			String sql = "SELECT customerId, accountNum, accType "
					+ "FROM Account WHERE customerId = ?"; 
			
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class), customerId);
		}

	// 입금 (deposit) : 회원 id, 입금 계좌번호
		public void deposit(String accountNum, double money) {
			String sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";
			jdbcTemplate.update(sql, getBalance(accountNum).get(0).getBalance() + money, accountNum );
	}

	// 출금 (withdrawal) : 회원 id, 출금 계좌번호, 출금할 돈 필요 
		public void withdraw(String accountNum, double money) {
			String sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";
			jdbcTemplate.update(sql, getBalance(accountNum).get(0).getBalance() - money, accountNum );
	}

	// 계좌 잔고 확인 (getBalance) : 계좌번호 필요
		public List<Account> getBalance(String accountNum) {
			String sql = "SELECT balance, accountNum FROM Account WHERE accountNum = ?";
			
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class), accountNum);
		}
		

	// 매달 말 계좌에 설정된 이자 지급 (savaInterest) : 이자율, 계좌번호 필요 (나중에)
		

	// 다른 계좌로 이체 (transfer) : 이체금액, 출금 계좌번호, 입금 계좌번호 필요
		
}
















