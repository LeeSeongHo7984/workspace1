package com.varxyz.jv200.mod007;

public class AnimalTest {
	public static void main(String[] args) {
//		Animal animal = new Animal();	// 추상화 클래스는 객체 생성 불가능
		Animal animal = new Cat();
		animal.makeSound();
	}
}
