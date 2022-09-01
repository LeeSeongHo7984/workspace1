package com.varxyz.banking.mvc.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.banking.mvc.dto.Account;

public class TransferDao {
	private JdbcTemplate jdbcTemplate;
	
	public TransferDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Account transfer() {
		return null;
	}
}
