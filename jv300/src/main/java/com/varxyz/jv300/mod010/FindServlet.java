package com.varxyz.jv300.mod010;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod010/find.do")	// servlet의 역활은 클라이언트 요청 처리, 그 결과를 반환
public class FindServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   private UserService userService = UserService.getInstance();
   
   public void init() throws ServletException {
	   super.init();
   }
   
   private static List<User> userList;

   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      
      request.setCharacterEncoding("UTF-8");
      
      RequestDispatcher dispatcher = null;
      
      userList = userService.getfindAllUser();
   
      request.setAttribute("userList", userList);
      System.out.println("COMPLITE");
           
      // NextPage
      dispatcher = request.getRequestDispatcher("find.jsp");
      System.out.println(1);
      dispatcher.forward(request, response);
      System.out.println(2);
   }
}