package org.unibl.etf.oop.interfaces.defaultmethods;

public class A1 implements I1 {
	public void method1() {
		System.out.println("method1...");
	}
	
	public static void main(String[] args) {
		A1 a = new A1();
		a.method1();
		a.method2();
//		a.method3();
	}
}
