package com.varxyz.jv300.mod005;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet2", urlPatterns = "/mod005/hello.do")
public class HelloServlet extends HttpServlet{
	private static final String DEFAULT_NAME = "World";
	// doGet이랑 파라미터(HttpServletRequest request, HttpServletResponse response)는 정해진것!!
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	// get 방식으로 servlet을 호출할 때 실행 
			throws ServletException, IOException {
		String pageTitle = "Hello Wrold";
		
		String name = request.getParameter("username");
		if(name == null || name.length() == 0) {
			name = DEFAULT_NAME;
		}
		
		response.setContentType("text/html; charset=UTF-8");	// 응답을 html로 하고 문자를 utf-8로 하겠다.
		PrintWriter out = response.getWriter();	// PrintWriter은 Writer의 자식
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3 style='color:blueviolet; text-align: center'> Hello, " + name + "</h3>");
		out.println("</body></html>");
		out.close();
	}
}
