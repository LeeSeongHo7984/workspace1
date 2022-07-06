

package com.varxyz.jv300.mod010;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class AddUserDao {
	private static AddUserDao instance = new AddUserDao();
	
	NameingService nameingService = NameingService.getInstance();
	DataSource datasource = (DataSource)nameingService.getAttribute("dataSource");
	
	  public void insertUser(User user) {
	      String sql = "INSERT INTO Signup (name, ssn, phone, userId, passwd)"
	               + "VALUES(?, ?, ?, ?, ?)";
	      try {
	         Connection con = null;
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
	public static AddUserDao getInstance() {
		return instance;
	}
}
