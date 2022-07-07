package com.varxyz.jv300.mod011;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.varxyz.jv300.mod010.DataSource;
import com.varxyz.jv300.mod010.NameingService;
import com.varxyz.jv300.mod010.User;

public class UserDao {
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	NameingService nameingService = NameingService.getInstance();
	DataSource datasource = (DataSource)nameingService.getAttribute("dataSource");
	
	// 신규 유저
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
				User user = new User();
				user.setUserId(rs.getString("userId"));
				user.setPasswd(rs.getString("passwd"));
				user.setUserName(rs.getString("userName"));
				user.setSsn(rs.getString("ssn"));
				user.setPhone(rs.getString("phone"));
				userList.add(user);
			}
		} finally {
			datasource.close(rs, pstmt, con);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return userList;
	}
	
}

