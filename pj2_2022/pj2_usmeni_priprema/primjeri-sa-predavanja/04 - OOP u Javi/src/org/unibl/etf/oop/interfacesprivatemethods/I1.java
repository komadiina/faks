package org.unibl.etf.oop.interfacesprivatemethods;

public interface I1 {
	default void method1() {							// 1
		method3();
		System.out.println("method1...");
	}
	default void method2() {							// 2
		method3();
		System.out.println("method2...");
	}
	private void method3(){								// 3
		System.out.println("private method...");
	}
}

