package com.varxyz.jv300.mod011;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
											throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String)session.getAttribute("userId");	
		
		if(userId == null) {	// userId가 null이면
			request.getRequestDispatcher("login.jsp").forward(request, response);	// login.jsp 페이지로 보낸다
			return ;
		}
		
		Cookie[] cookies = request.getCookies();	// 쿠키는 문자로만 가능
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
			if(cookie.getName().equals("lastAccessTime")) {
				request.setAttribute("lastAccessTime", URLDecoder.decode(cookie.getValue(), "UTF-8"));	// 최근 방문 기록 확인
			}
		}
		
		response.addCookie(lastAccessTime());
		
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}
	
	private Cookie lastAccessTime() {	// 메소드 생성
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	// 년도-달-일 시간-분-초
		String dateStr = format.format(new Date());
		
		Cookie cookie = null;
		try {
			cookie = new Cookie("lastAccessTime", URLEncoder.encode(dateStr, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		cookie.setMaxAge(60 * 60 * 24 * 30);
		cookie.setPath("/");
		return cookie;
	}


}















