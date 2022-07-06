package com.varxyz.jv200.mod007;

public class Airplane implements Flyer, Vehicle {	
	// public class Airplane implements Flyer, 뒤에 오는 거는 interface 이다.
	// 위 코드에서는 Vehicle 가 interface 이다.

	public void fly() {
		System.out.println("비행기 : 날기");
	}

	public void takeOff() {
		System.out.println("비행기 : 이륙하기");
	}

	public void land() {
		System.out.println("비행기 : 착륙하기");
	}

}
