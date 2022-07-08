package com.varxyz.jv300.mod011;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mod011/login")	// 여기있는 경로는 jsp <form action="여기" 경로와 같야 한다
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = UserService.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);	// login.jsp로 보내주는 역할을 함
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException {
		
		// 3. getParameter로 받아올거라는거 받아옴 그리고 변수에 집어넣음
		String userId = request.getParameter("userId");	// jsp에 name 값이 () 괄호 안에 값, 로그인 페이지에서 내가 친 값
		String passwd = request.getParameter("passwd");	// jsp에 name 값이 () 괄호 안에 값, 로그인 페이지에서 내가 친 값	
		
		// 요청 파라메터 검증
		// ...
		// 4. 집어 넣은 변수를 isValidUser 메소드에 넣어서 호출함 
		if(!userService.isValidUser(userId, passwd)) {
			// 10. 들어간 결과가 False면 여기
			request.getRequestDispatcher("login.jsp").forward(request, response);	// 아니면 로그인 페이지로 보낸다.
			return;
		}
		
		// 11. 아니면 여기 -끝-
		HttpSession session = request.getSession(true); // getSession(boolean)
		session.setAttribute("userId", userId);	// setAttribute(String, Object);
		// sendRedirect : java Servlet에서 이동을 위한 메소드이다. 오직 이동만 한다. 데이터를 가지고 가지 않는다.
		response.sendRedirect("mypage"); 	// mypage로 이동
	}

}
