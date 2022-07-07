package com.varxyz.jv300.mod010;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AddUserDao {
	private static AddUserDao instance = new AddUserDao();	// 싱글톤, static은 모든 객체가 메모리를 공유
	
	public static AddUserDao getInstance() {
		return instance;
	}
	
	NameingService nameingService = NameingService.getInstance();
	DataSource datasource = (DataSource)nameingService.getAttribute("dataSource");

	// 신규 가입
	  public void insertUser(User user) {
	      String sql = "INSERT INTO Signup (name, ssn, phone, userId, passwd)"
	               + "VALUES(?, ?, ?, ?, ?)";
	      try {
	         Connection con = null;
	         // PreparedStatment 클래스 사용시, sql 매개변수를 부여하여 실행할 수 있다.
	         PreparedStatement  pstmt = null;	
	         try {
	            con = datasource.getConnection();
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, user.getUserName());
	            pstmt.setString(2, user.getSsn());
	            pstmt.setString(3, user.getPhone());
	            pstmt.setString(4, user.getUserId());
	            pstmt.setString(5, user.getPasswd());
	            pstmt.executeUpdate();

	         } finally{
	        	 datasource.close(pstmt,con);
	         }

	         System.out.println("NEW User in");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	// 유저 조회
	public List<User> findAllUser() {
		String sql = "SELECT * FROM Signup";
		List<User> userList = new ArrayList<>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		try {
			con = datasource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				User u = null;
				u.setUserId(rs.getString("userId"));
				u.setPasswd(rs.getString("passwd"));
				u.setUserName(rs.getString("userName"));
				u.setSsn(rs.getString("ssn"));
				u.setPhone(rs.getString("phone"));
			}
		} finally {
			datasource.close(pstmt, con);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return userList;
	}
 
}
