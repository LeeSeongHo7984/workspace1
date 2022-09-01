package com.varxyz.banking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.banking.mvc.dao.CheckingAccount;
import com.varxyz.banking.mvc.dao.SavingAccount;
import com.varxyz.banking.mvc.dto.Account;
import com.varxyz.banking.mvc.dto.Customer;

public class CustomerAccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		System.out.println(2);
		account.setCustomerId(rs.getString("customerId"));
		account.setAccountNum(rs.getString("accountNum"));
		account.setAccType(rs.getString("accType"));
		System.out.println(account.getAccountNum());
		
		return account;

	}

}