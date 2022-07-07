package com.varxyz.jv300.mod011;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mod011/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public void init() {
		userService = new UserService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String)session.getAttribute("userId");
		if(userId == null) {	// userId가 null이면
			request.getRequestDispatcher("login.jsp").forward(request, response);	// login.jsp 페이지로 보낸다
			return ;
		}
		
		request.getRequestDispatcher("mypage.jsp");
	}


}
