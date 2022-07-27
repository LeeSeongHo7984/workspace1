package com.varxyz.banking.mvc.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.mapper.CustomerAccountRowMapper;
import com.varxyz.banking.mvc.dto.Account;

@Repository("accountDao")
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 계좌 생성
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
	
	// 고객아이디로 계좌 조회
		public List<Account> findAccountsByCustomerId(String customerId) {
			String sql = "SELECT customerId, accountNum, accType "
					+ "FROM Account WHERE customerId = ?"; 
			
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class), customerId);
		}
}



















