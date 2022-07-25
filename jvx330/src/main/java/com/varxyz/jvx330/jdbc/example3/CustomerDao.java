package com.varxyz.jvx330.jdbc.example3;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerDao {
   private JdbcTemplate jdbcTemplate;
   
   public CustomerDao(DataSource dataSource) {
      jdbcTemplate = new JdbcTemplate(dataSource);
   }
   
   // 전체조회
   public List<Customer> findAllCustomers() {

      String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
      
      return jdbcTemplate.query(sql, new CustomerRowMapper());
   }
   
   // 오늘 만든 사람 날짜로 조회
   public List<Customer> findCustomerByRegDate(Date regDate) {

      String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
            + " FROM Customer WHERE DATE(regDate) = ?";
      
      return jdbcTemplate.query(sql, new CustomerRowMapper());
   }
   
   // 이메일로 조회
   public Customer findCustomerByEmail(String email) {

      String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
            + " FROM Customer WHERE email = ?";
      
      return jdbcTemplate.queryForObject(sql, new CustomerRowMapper()); // queryForObject 여러개의 List를 반환해준다
      
   }
   
   // 전체 고객 갯수 조회
   public long countCustomers() {
      String sql = "SELECT count(*) FROM Customer";
      return jdbcTemplate.queryForObject(sql, Long.class);
   }
}