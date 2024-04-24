package org.unibl.etf.nestedclasses.staticnested;

public class Outer {
	static String staticOuterProp = "a";
	String nonstaticOuterProp = "b";
	static class Nested{
		public void method() {
			System.out.println(staticOuterProp);
//			System.out.println(nonstaticOuterProp);
			Outer outer = new Outer();
			System.out.println(outer.nonstaticOuterProp);
		}
		
		public static void staticMethod() {
			System.out.println("from static method");
		}
	}
	
	static private void method() {
		Nested nested = new Nested();
		nested.method();
		Nested.staticMethod();
	}
	
	public static void main(String[] args) {
		Outer.Nested nested = new Outer.Nested();
		nested.method();
		Outer.Nested.staticMethod();
	}
}


