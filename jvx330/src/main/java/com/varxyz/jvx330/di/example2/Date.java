package com.varxyz.jvx330.di.example2;

import lombok.AllArgsConstructor;

@AllArgsConstructor	// 모든생성자
public class Date {
	private int year;
	private int month;
	private int day;
	
	public String toString() {	// system.out.println으로 객체를 호출할때 toString이 자동으로 호출됨
		return year + "-" + month + "-" + day;
	}
	
	public int hashCode() {
		return(day ^ month ^ year);
	}
}
