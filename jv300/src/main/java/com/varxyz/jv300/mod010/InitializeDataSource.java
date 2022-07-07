package com.varxyz.jv300.mod010;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.varxyz.jv300.mod010.DataSource;
import com.varxyz.jv300.mod010.NameingService;

@WebListener
public class InitializeDataSource implements ServletContextListener {	
	// ServletContextListener 은 웹 애플리케이션이 시작/종료 전까지 호출 이벤트 발생 시 처리
   private static final String JDBC_FILE_PATH = "/WEB-INF/classes/jdbc.properties";	// JDBC 파일 경로
   
   public void contextInitialized(ServletContextEvent event)  {
	   // ServletContext는 하나의 서블릿이 서블릿 컨테이너와 통신하기 위해서 
	   // 사용되어지는 메서드들을 가지고 있는 클래스
        ServletContext context = event.getServletContext();
        InputStream is = null;	// InputStream은 데이터를 byte 단위로 읽어들이는 통로
        try {
         is = context.getResourceAsStream(JDBC_FILE_PATH);
         // Properties : Key=Value형식으로 파라미터 정보들을 저장하기 위한 파일 확장자를 의미
         Properties prop = new Properties(); 
         prop.load(is);	// load는 파일의 내용을 읽어서 키-값의 형태로 분류하여 맵에 보관
         
         String jdbcDriver = prop.getProperty("jdbc.driver");
         String jdbcUrl = prop.getProperty("jdbc.url");
         String userName = prop.getProperty("jdbc.username");
         String password = prop.getProperty("jdbc.password");
         
         DataSource dataSource = new DataSource(jdbcDriver, jdbcUrl, userName, password);   // 데이터 소스 생성
         
         NameingService namingService = NameingService.getInstance();	// 네이밍서비스 클래스 안에 객체를 불러서 namingService에 넣음
         namingService.setAttribute("dataSource", dataSource);

         System.out.println("DataSource has been initilized.");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

    public void contextDestroyed(ServletContextEvent event)  { 
         
    }
    
}