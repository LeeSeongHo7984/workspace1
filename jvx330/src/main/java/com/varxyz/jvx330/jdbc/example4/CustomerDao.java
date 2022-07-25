package com.varxyz.jvx330.jdbc.example4;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerDao {
   private JdbcTemplate jdbcTemplate;
   
   public CustomerDao(DataSource dataSource) {
      jdbcTemplate = new JdbcTemplate(dataSource);
   }
   
   // 전체 조회
   public List<Customer> findAllCustomers(){
      String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
      
      return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class)); 
   }   
   
   // 날짜로 조회
   public List<Customer> findCustomerByRegDate(Date regDate) {
	   String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
	   		+ "FROM Customer WHERE DATE(regDate)=?";
	   return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class), regDate);	//jdbcTemplate.query 쓰면 뒤에 쿼리가 얼마가 나와도 상관없음
   }
   
   
   // 주민번호로 조회
   public Customer findCustomerBySsn(String ssn) {
	   String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
	   		+ "FROM Customer WHERE ssn=?";
	   return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {
		   
	         @Override
	         public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"), 
	                      rs.getString("name"), rs.getString("passwd"), rs.getString("ssn"), 
	                      rs.getString("phone"), rs.getDate("regDate"));
	            return customer;
	         }
	   
	   }, ssn);
 	}
   
   // 이메일로 조회
   public Customer findCustomerByEamil(String email) {
	   String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
		   		+ "FROM Customer WHERE email=?";
	   return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), email);
   }   

   public long countCustomers() {
	   String sql = "SELECT count(*) FROM Customer";
	   return jdbcTemplate.queryForObject(sql, Long.class);
   }
   
}