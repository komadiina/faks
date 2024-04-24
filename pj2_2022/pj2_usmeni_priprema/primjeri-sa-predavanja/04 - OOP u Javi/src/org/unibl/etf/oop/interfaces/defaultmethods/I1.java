package org.unibl.etf.oop.interfaces.defaultmethods;

interface I1 {
	void method1();									// 1
	
	default void method2() {						// 2
		method3();
		System.out.println("default method...");
	}
	
	private void method3() {
		System.out.println("private method...");
	}
}

