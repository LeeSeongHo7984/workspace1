package com.varxyz.jv300.mod007;

public class UserService {
   
   private static UserService instance = new UserService(); // 싱글톤
   
   private UserService() {
      
   }
   
   public static UserService getInstance() {
      return instance;
   }
   
   public void addUser(User user) {
//      System.out.println(user.getUserId().toString());
//      System.out.println(user.getPasswd().toString());
//      System.out.println(user.getUserName().toString());
   }
}