package com.varxyz.jv300.mod011;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
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
      String sql = "INSERT INTO Signup (userName, ssn, phone, userId, passwd)"
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
	
	// 내가 친 아이디, 비번이랑 DB에 저장된 아이디, 비번 일치하는지 확인하는 코드
	
	// 7. DB정보랑 내가 입력한 정보를 비교하는 로직을 구현해놓음
	// 8. 결과는 return 으로 반환함
	public boolean equalsUser(String userId, String passwd) {
		String sql = "SELECT userId, passwd FROM Signup WHERE userId = ?";
		boolean result = false;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = datasource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					User user = new User(); //유저 객체 생성하기
					user.setUserId(rs.getString("userId"));	// DB에 저장된 아이디를 생성한 객체에 넣기
					// rs.getString("userId") == db저장되어 있는 userId값들 전부
					user.setPasswd(rs.getString("passwd")); // DB에 저장된 비번을 생성한 객체에 넣기
					
					if(userId.equals(user.getUserId()) && passwd.equals(user.getPasswd())) {
						result = true;
					} else {
						result = false;
					}
				}
			} finally {
				datasource.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

