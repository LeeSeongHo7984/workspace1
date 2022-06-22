package com.varxyz.jv250.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample5 {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";	// 서버주소
		String id = "jv250";
		String passwd = "jv250";
		
		try {
			Class.forName(driver);
			System.out.println("LOAD DRIVER --->" + driver);
			
			Connection con = DriverManager.getConnection(url, id, passwd);	// sql쪽 exception은 checked exception이기 때문에 무조건 try catch로 잡아줘야 한다
			System.out.println("CONNECTED TO --->" + url);
			
			String sql = "DELETE FROM Customer WHERE name = ?";
			PreparedStatement stmt = con.prepareStatement(sql);	// statment 생성
			stmt.setString(1, "조조");
			stmt.executeUpdate();
			
			System.out.println("DELETED....");
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
}
