package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {
	   public static void main(String[] args) {
	      String driver = "com.mysql.cj.jdbc.Driver";
	      String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	      String id = "jv250";
	      String passwd = "jv250";
	      
	      try {
	            Class.forName(driver);
	            System.out.println("LOADED DRIVER ---> " + driver);
	            
	            Connection con = DriverManager.getConnection(url, id, passwd);
	            System.out.println("CONNECTED TO ---> " + url);
	            
	            String sql = "SELECT * FROM Customer WHERE name=?";
	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setString(1, "성호");
	            ResultSet rs = stmt.executeQuery(); //ResultSet -> 실행해서 받아온 결과 //executeQuery -> 쿼리 실행
	            while(rs.next()) {
	               long cid = rs.getLong("cid");
	               String customerId = rs.getString("customerId");
	               String name = rs.getString("name");
	               String phone = rs.getString("phone");
	               System.out.println(cid);
	               System.out.println(customerId);
	               System.out.println(name);
	               System.out.println(phone);
	               System.out.println("---------------------");
	            }
	            rs.close();
	            stmt.close();
	            con.close();
	            
	         } 
	         catch (Exception e) {
	            e.printStackTrace();
	         }
	         finally {
	            
	         }
	   }
	}