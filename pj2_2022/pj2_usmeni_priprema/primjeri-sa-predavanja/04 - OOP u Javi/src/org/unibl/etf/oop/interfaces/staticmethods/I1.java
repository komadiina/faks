package org.unibl.etf.oop.interfaces.staticmethods;

public interface I1 {
	void method1();									// 1
	static void staticMethodI1() {							// 2
		System.out.println("static method from I1...");
	}
}

interface I2 {
	
}
class A extends B implements I1 {
	public static void main(String[] args) {
		I1.staticMethodI1();								// 3
//		staticMethodI1();
		B.staticMethodB();
		A a = new A();
		a.method1();
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
	}
}

class B {
	static void staticMethodB() {
		System.out.println("static method from B...");
	}
}
