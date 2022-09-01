package com.varxyz.jvx330.jdbc.example5;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.varxyz.jvx330.jdbc.example5") 
// basePackages = "" 은 이 패키지 안에 자기자신이랑 폴더랑 서브폴더랑 밑에 애들을 다 스캔함
public class Example5Config {
	
	@Bean(destroyMethod = "close")	// 다썼으면 close로 해제 시키겠다
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jvx330?serverTimezone=Asia/Seoul");
		ds.setUsername("jvx330");
		ds.setPassword("jvx330");
		ds.setInitialSize(2);	// 커넥션 풀 초기화시 생성할 초기 커넥션 갯수
		ds.setMaxActive(10);	// 풀에서 가져올 수 있는 최대 커넥션 갯수
		ds.setMaxIdle(10);	// 풀에 유지할 수 있는 최대 커넥션 수(기본값은 maxActive와 동일)
		return ds;
	}
	
	@Bean
	public AccountDao addAccount() {
		return new AccountDao(dataSource());
	}
}
