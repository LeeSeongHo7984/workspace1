package com.varxyz.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod004/add_user.do")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("userId");
		String pass = request.getParameter("passwd");
		String name = request.getParameter("userName");
		String ssn = request.getParameter("ssn");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String[] concerns = request.getParameterValues("concerns");
		
		String pageTitle = "User";
		response.setContentType("text/html; charset=UTF-8");	// 응답을 html로 하고 문자를 utf-8로 하겠다.
		PrintWriter out = response.getWriter();	// PrintWriter은 Writer의 자식
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3> 회원가입이 완료되었습니다.</h3>");
		out.println("<p> 아이디 : " + user + "</p>");
		out.println("<p> 비밀번호 : " + pass + "</p>");
		out.println("<p> 이름 : " + name + "</p>");
		out.println("<p> 주민번호 : " + ssn + "</p>");
		out.println("<p> 이메일 :  " + email1 + "@" + email2 + "</p>");
		out.println("<p> 관심분야 : ");
		for(String c : concerns) {
			out.print(c);
		}
		out.println("</p>");
		out.println("</body></html>");
		out.close(); 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
