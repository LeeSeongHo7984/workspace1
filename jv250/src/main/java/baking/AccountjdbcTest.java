package baking;

import java.sql.Connection;
import java.sql.DriverManager;

public class AccountjdbcTest {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";	// 서버주소
		String id = "jv250";
		String passwd = "jv250";
		
		try {
			Class.forName(driver);
			System.out.println("LOAD DRIVER --->" + driver);
		
			Connection con = DriverManager.getConnection(url, id, passwd);	
			System.out.println("CONNECTED TO --->" + url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insert() {
		
	}
}
