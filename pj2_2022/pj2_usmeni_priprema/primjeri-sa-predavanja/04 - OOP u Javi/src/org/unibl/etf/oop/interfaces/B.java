package org.unibl.etf.oop.interfaces;

public class B extends A implements I1, I2 { // 1
	
	@Override
	public void method2() {
		System.out.println("method2 from B...");
	}

	@Override
	public void method3() {
		System.out.println("method3 from B...");
	}

	public static void main(String[] args) {
		B b1 = new B();
		A b2 = new B();
		I1 b3 = new B();
		I2 b4 = new B();

		b1.method1();
		b1.method2();
		b1.method3();

		System.out.println("x");

		b2.method1();

		System.out.println("x");

		b3.method1();
		b3.method2();

		System.out.println("x");

		b4.method1();
		b4.method3();
	}
}

class A {
	public void method1() { 				// 2
		System.out.println("method1 from A...");
	}
}

interface I1 {
	void method1(); 						// 3
	void method2();
}

interface I2 {
	void method1(); 						// 4
	void method3();
}
