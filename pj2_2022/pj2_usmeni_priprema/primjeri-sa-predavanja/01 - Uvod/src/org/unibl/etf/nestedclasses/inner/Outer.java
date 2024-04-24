package org.unibl.etf.nestedclasses.inner;

public class Outer {
	String outerProperty = "outer property value";
	
	void method() {
		System.out.println("Outer class - method: " + outerProperty);
		Nested nestedClass = new Nested();
		nestedClass.method();
//		System.out.println(innerProperty);
	}
	
	public class Nested{
		String innerProperty = "inner property value";
		void method() {
			System.out.println("InnerClass - method: " + 
					outerProperty + " " + innerProperty);
		}
	}
	
	public static void main(String[] args) {
		Outer outerClass = new Outer();
		outerClass.method();
		Outer.Nested nested = outerClass.new Nested();
		nested.method();
	}
}



