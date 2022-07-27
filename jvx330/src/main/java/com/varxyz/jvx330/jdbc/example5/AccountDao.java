package com.varxyz.jvx330.jdbc.example5;

import static java.sql.Types.*;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.varxyz.jvx330.jdbc.Account;

@Component("accountDao")	// Dao는 Component
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 계좌 생성
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account (accountNum, accType, balance, interestRate, overAmount) ";
		
		SavingAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		int[] types = new int[] {CHAR, CHAR, DOUBLE, DOUBLE, DOUBLE, BIGINT};
		
		if(account instanceof SavingAccount) {
			sa = (SavingAccount)account;
			args = new Object[] {
					sa.getAccountNum(), String.valueOf(sa.getAccountType()), sa.getBalance(), 
					sa.getInterestRate(), 0.0, sa.getCustomer().getCid()
			};
		} else {
	         ca = (CheckingAccount)account;
	         args = new Object[] {
	               ca.getAccountNum(), String.valueOf(ca.getAccountType()),
	               ca.getBalance(), 0.0, ca.getOverdraftAmount(),
	               ca.getCustomer().getCid()
	         };
	      }
		
		jdbcTemplate.update(sql, args, types);
	}

	// 주민번호로 계좌 조회
	public List<Account> findAccountsBySsn(String ssn) {
		
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance, "
				+ " a.interestRate, a.overAmount, a.regDate "
				+ " FROM Account a INNER JOIN Customer c "
				+ " ON a.customerId = c.cid "
				+ " WHERE c.ssn = ?"; 
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), ssn);
	}
	
	// 고객아이디로 계좌 조회
	public List<Account> findAccountsByCustomerId(long customerId) {
		
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance, "
				+ " a.interestRate, a.overAmount, a.regDate "
				+ " FROM Account a INNER JOIN Customer c "
				+ " ON a.customerId = c.cid "
				+ " WHERE a.customerId = ?"; 
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), customerId);
	}
 
}
