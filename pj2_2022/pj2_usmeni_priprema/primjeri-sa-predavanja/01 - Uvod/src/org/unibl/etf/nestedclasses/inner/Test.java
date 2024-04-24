package org.unibl.etf.nestedclasses.inner;

import org.unibl.etf.nestedclasses.inner.Outer.Nested;

public class Test {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method();
		Outer.Nested nested = outer.new Nested();
		nested.method();
//		Nested n = new Nested();
		test();
		test2(new Test2() {
			@Override
			public void method() {
				System.out.println("new method");
			}
		});
	}
	
	public static void test() {
		class X{
			X(){
				System.out.println("X");
			}
			void methodX() {
				System.out.println("methodX");
			}
		}
		X x = new X();
		x.methodX();
	}

	public static void test2(Test2 t) {
		t.method();
	}
}

class Test2{
	public void method() {
		System.out.println("Test2.method()");
	}
}
