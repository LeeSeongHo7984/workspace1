package com.varxyz.jv200.mod007;

public class Book {
	private int serial;	// 시리얼 번호
	private String name;	// 책 이름
	
	public Book(int serial, String name) {
		this.serial = serial;
		this.name = name;
	}
	
	public int getSerial() {
		return serial;
	}
	
	public int setSerial(int serial) {
		this.serial = serial;
		return serial;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}