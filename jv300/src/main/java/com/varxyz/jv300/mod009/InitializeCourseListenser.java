package com.varxyz.jv300.mod009;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeCourseListenser implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event)  { 
		System.out.println("contextInitialized() method called");

		ServletContext context = event.getServletContext();
		InputStream is = null;	// InputStream : 파일을 읽겠다
		BufferedReader reader = null;
		List<String[]> contentList = new ArrayList<>();
		try {
			is = context.getResourceAsStream("/WEB-INF/classes/course_contents.txt");
			reader = new BufferedReader(new InputStreamReader(is));	// InpustStreamReader는 생성자 InputStream을 주면 InputStreamReader를 만들어 주고 BufferedReader에 넣어 BufferedReader을 생성
			String record = null;
			while((record = reader.readLine()) != null) {	// readLine : 자바 파일 내용 한줄씩 읽어들이기
				String[] fields = record.split("\t");
				contentList.add(fields);
			}
			context.setAttribute("contentList", contentList);
			context.log("The course contents has been load");
		} catch(Exception e) {
			e.printStackTrace();	// e.printStackTrace() : 에러의 발생근원지를 찾아서 단계별로 에러를 출력
		}
	}
	
	@Override
    public void contextDestroyed(ServletContextEvent event)  { 
         System.out.println("contextDestroyed() method called");
    }
	
	@SuppressWarnings("unused")
	private String escapeHtml(String line) {
		if(line.length() == 0) {
			return line;
		}
		return line.replace("<", "&lt;").replace(">", "&gt;");
	}

}
