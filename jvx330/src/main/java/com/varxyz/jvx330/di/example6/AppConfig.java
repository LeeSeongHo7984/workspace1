package com.varxyz.jvx330.di.example6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages  = {"com.varxyz.jvx330.di.example6"})	// 이 패키지 안에 있는 모든 클래스들은 검색해서 bean들을 등록해라

public class AppConfig {
	
}

