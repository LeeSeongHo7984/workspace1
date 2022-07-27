package com.varxyz.banking.jdbc;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.banking.mvc.dao.AccountDao;
import com.varxyz.banking.mvc.dao.CustomerDao;

@Configuration	
@ComponentScan(basePackageClasses = {CustomerDao.class, AccountDao.class})

public class DataSourceConfig {	
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/banking?serverTimezone=Asia/Seoul");
		ds.setUsername("banking");
		ds.setPassword("banking");
		ds.setInitialSize(2);	// 커넥션 풀 초기화시 생성할 초기 커넥션 갯수
		ds.setMaxActive(10);	// 풀에서 가져올 수 있는 최대 커넥션 갯수
		ds.setMaxIdle(10);	// 풀에 유지할 수 있는 최대 커넥션 수(기본값은 maxActive와 동일)
		return ds;
	}
	
	@Bean 
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

}
