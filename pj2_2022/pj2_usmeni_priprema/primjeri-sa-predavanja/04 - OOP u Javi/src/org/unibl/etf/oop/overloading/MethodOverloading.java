package org.unibl.etf.oop.overloading;

public class MethodOverloading {

	public void method(Object obj){		// 1
		System.out.println("method - Object param");
	}

	public void method(Integer obj){		// 2
		System.out.println("method - Integer param");
	}

	public void method(Number obj){		// 3
		System.out.println("method - Number param");
	}
	
//	public void method(Double obj){		// 4
//		System.out.println("method - Double param");
//	}

	public static void main(String[] args) {
		MethodOverloading m = new MethodOverloading();
		m.method(null);
	}
}
