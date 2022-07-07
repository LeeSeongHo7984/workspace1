package com.varxyz.jv300.mod010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {	
	private String jdbcDriver;	// jdbcDriver : dbms와 통신을 담당하는 자바 클래스
	private String jdbcUrl;		// jdbcUrl : dbms와 연결을 위한 식별자
	private String jdbcUserName;
	private String jdbcPassWord;
	
	public DataSource(String jdbcDriver,String jdbcUrl, String jdbcUserName, String jdbcPassWord) {
		super();
		this.jdbcDriver = jdbcDriver;
		this.jdbcUrl = jdbcUrl;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassWord = jdbcPassWord;
		
	      try {
	    	// Class.forName(jdbcDriver); :  데이터 베이스와 연결할 드라이버 클래스를 찾아서 로드하는 역할 
	    	//  괄호 안에 (jdbcDriver)는 jdbc드라이버 이름
	          Class.forName(jdbcDriver);	
	        //  Class.forName에 해당하는 예외처리를 해줘야한다.
	       }catch(ClassNotFoundException e) {
	          throw new RuntimeException("JdbcNotFoundException");
	       }
	}
	
	
	public Connection getConnection() {
		try {
		 // DriverManager.getConnection() 은 실제 자바프로그램과 데이터베이스를 네트워크상에서 연결을 해주는 메소드
			return DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassWord);	
		} catch (SQLException e) {
			throw new RuntimeException("ConnectionNotAvailableException");
		}
	}
	
	// ResultSet 클래스는 Statement 객체로 SELECT문을 사용하여 얻어온 레코드 값들을 테이블의 형태로 갖는 객체
	// PreparedStatment 클래스 사용시, sql 매개변수를 부여하여 실행할 수 있다.
	// Connection은 자바프로그램에서 SQL문을 실행하기 위해 DB를 연결해 주는 작업
	public void close(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null && !rs.isClosed()) {
			rs.close();
		}
		if(pstmt !=null && !pstmt.isClosed()) {
			pstmt.close();
		}
		// 객체가 정상적으로 생성되었다면 더이상 con은 null 값을 가지지 않으므로 
		// con.close();로 Connection객체를 닫아준다.
		if(con != null && !con.isClosed()) {
			con.close();
		}
	}
	
	public void close(PreparedStatement pstmt, Connection con) throws SQLException{
		close (null, pstmt, con);
	}
}


