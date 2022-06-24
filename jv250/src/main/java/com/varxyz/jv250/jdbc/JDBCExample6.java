package com.varxyz.jv250.jdbc;

import java.sql.*;
/**
 * 
 * java를 이용한 DB account table 정보 불러오기
 * 
 * @author Administrator
 *
 */
public class JDBCExample6 {
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
         
         String sql = "SELECT * FROM Account";
         PreparedStatement stmt = con.prepareStatement(sql);   
         ResultSet rs = stmt.executeQuery();
         while(rs.next()) {
            long aid = rs.getLong("aid");
            String accountNum = rs.getString("accountNum");
            System.out.println(aid);
            System.out.println(accountNum);
            System.out.println("--------------------------------");
         }
         stmt.close();
         con.close();
         
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
      
   }
}