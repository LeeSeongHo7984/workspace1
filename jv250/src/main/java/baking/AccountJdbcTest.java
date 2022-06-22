package baking;

import java.sql.*;

public class AccountJdbcTest {
   public static void main(String[] args) {
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
      String id = "jv250";
      String passwd = "jv250";
      
      try {
         Class.forName(driver);
         System.out.println("LOADED DRIVER --->" + driver);
         
         Connection con = DriverManager.getConnection(url, id, passwd);
         System.out.println("CONNECTED TO --->" + url);
         
         select(con);
         insert(con);
         select(con);
         con.close();
      }   catch (Exception e) {
            e.printStackTrace();      
         }   
   }
   
   public static void select(Connection con) {
      String sql = "SELECT * FROM Account";
      try {
         PreparedStatement pstmt = con.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            long aid = rs.getLong("aid");
            String accountNum = rs.getString("accountNum");
            double balance = rs.getDouble("balance");
            double interestRate = rs.getDouble("interestRate");
            double overdraft = rs.getDouble("overdraft");
            char accountType = rs.getString("accountType").charAt(0);
            System.out.println("--------------");
            System.out.println(aid);
            System.out.println(accountNum);
            System.out.println(balance);
            System.out.println(interestRate);
            System.out.println(overdraft);
            System.out.println(accountType);
         }
         pstmt.close();
         
         System.out.println("SELECT COMPLETED...\n");
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public static void insert(Connection con) {
      String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft, accountType,customerId) VALUES (?, ?, ?, ?, ?, ?)";
      
      try {
         PreparedStatement pstmt = con.prepareStatement(sql);
         pstmt.setString(1, "123-45-7891");
         pstmt.setDouble(2, 30000.0);
         pstmt.setDouble(3, 0.03);
         pstmt.setDouble(4, 0.0);
         pstmt.setString(5, String.valueOf('S'));
         pstmt.setLong(6, 1003);
         pstmt.executeUpdate();
         pstmt.close();
         System.out.println("NEW ACCOUNT INSERTED...\n");
      } catch (Exception e) {
         e.printStackTrace();   
      }
   }
}