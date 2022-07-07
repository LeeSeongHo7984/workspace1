package com.varxyz.jv300.mod010;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod010/sign_up.do")	// servlet의 역활은 클라이언트 요청 처리, 그 결과를 반환
public class AddUserServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   private UserService userService = UserService.getInstance();
      
   public void init(ServletConfig config) throws ServletException {
      super.init();
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      
      request.setCharacterEncoding("UTF-8");
      //1. 폼 파라메터 얻기
      String userId = request.getParameter("userId");
      String passwd = request.getParameter("passwd");
      String userName = request.getParameter("userName");
      String phone = request.getParameter("phone");
      String ssn = request.getParameter("ssn");
      
   
      
      //2. 유효성 검증 및 반환
      List<String> errorMsgs = new ArrayList<>();
      if(userId == null || userId.length() == 0) {
         errorMsgs.add("id는 필수입력 정보입니다.");
      }else if(passwd == null || passwd.length() == 0) {
         errorMsgs.add("비밀번호는 필수입력 정보입니다.");
      }
      
      RequestDispatcher dispatcher = null;
      if(errorMsgs.size() > 0) {
         dispatcher = request.getRequestDispatcher("error.jsp");
         request.setAttribute("errorMsgs", errorMsgs);
         dispatcher.forward(request, response);
         return;
      }
      
      User user = new User();
      user.setUserId(userId);
      user.setPasswd(passwd);
      user.setUserName(userName);
      user.setPhone(phone);
      user.setSsn(ssn);

      
      //3. 비즈니스 서비스 호출
      userService.addUser(user);

      request.setAttribute("user", user);
      
      //4. NextPage
      dispatcher = request.getRequestDispatcher("success.jsp");
      dispatcher.forward(request, response);
   }
}