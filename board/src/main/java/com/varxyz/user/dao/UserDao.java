package com.varxyz.user.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.user.domain.User;

@Repository
public class UserDao {
	private JdbcTemplate jdbcTemplate;
	
	public UserDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 회원가입
	public void addUser(User user) {
		String sql = "INSERT INTO User (userId, passwd, name, ssn, address, phone) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, user.getUserId(), user.getPasswd(), user.getName(), 
				user.getSsn(), user.getAddress(), user.getPhone());
	}

	// 회원 정보
	public List<User> readUser(String userId) {
		String sql = "SELECT * FROM User WHERE userId = ? ";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), userId);
	}

	// 회원 정보 수정
	public void userModify(User user) {
		String sql = "UPDATE User SET passwd = ?, name = ?, ssn = ?, address = ?, phone = ? WHERE userId = ?";
		
		jdbcTemplate.update(sql, user.getPasswd(), user.getName(), user.getSsn(), 
								user.getAddress(), user.getPhone(), user.getUserId());
		
	}
	
	// 회원 탈퇴
	public void userDelete(String userId) {
		String sql = "DELETE FROM User where userId = ?";
		
		jdbcTemplate.update(sql, userId);
		
	}

}
