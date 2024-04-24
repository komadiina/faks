package org.unibl.etf.oop.interfaces;

public interface Interface {						// 1
	void method1();									// 2
	void method2();									// 3
}

class InterfaceImplementation implements Interface{	// 4

	public void method1() {							// 5
		System.out.println("method1...");
	}

	public void method2() {							// 6
		System.out.println("method2...");
	}
}

abstract class PartialImplementation implements Interface{

	@Override
	public void method1() {
		System.out.println("method1...");
	}

	public void method3() {
		
	}
}

