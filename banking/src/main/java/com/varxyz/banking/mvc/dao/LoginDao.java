package com.varxyz.banking.mvc.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.mvc.dto.Customer;

@Repository("loginDao")	
public class LoginDao {
	private JdbcTemplate jdbcTemplate;
	
	public LoginDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 로그인 (login)
		public Customer login(String inputId) {
			String sql = "SELECT userId, passwd "
					+ "FROM Customer WHERE userId = ?";	
		
		//4. Dao -> controller	
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), inputId); //db 안에 있는 값을 비교
		// new BeanPropertyRowMapper<Customer>(Customer.class) : db 저장된값, 뒤에 x는 내가 친 값
		// (sql, new BeanPropertyRowMapper<Customer>(Customer.class), x) 에서
		//	젤 뒤에 x는 물음표에 들어가는 값만 쓴다 (where userId = ? )
		
		// queryForObject = 정해준 객체의 setter에 자동으로 값을 넣어서 반환해준다.
		// query = 정해준 객체의 setter에 자동으로 값을 넣어서 리스트로 반환해준다.
			
		}
	
	
	
}
