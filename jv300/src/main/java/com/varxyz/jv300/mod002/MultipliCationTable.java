package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultipliCationTable extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String pageTitle = "구구단";
		response.setContentType("text/html; charset=UTF-8");	// 응답을 html로 하고 문자를 utf-8로 하겠다.
		PrintWriter out = response.getWriter();	// PrintWriter은 Writer의 자식
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3 style='color:blueviolet; text-align: center'> 구구단</h3>");
		out.println("<p>" + multiple() + "</p>");
		out.println("</body></html>");
		out.close(); 
	}
		
	public String multiple() {
		String m = "";
		
		for (int j = 1; j < 10; j++) {
			for (int i = 2; i < 10; i++) {
				m += (i + "*" + j + "=" + (i*j) + "\t");
				}
			}
		return m;
	}
}