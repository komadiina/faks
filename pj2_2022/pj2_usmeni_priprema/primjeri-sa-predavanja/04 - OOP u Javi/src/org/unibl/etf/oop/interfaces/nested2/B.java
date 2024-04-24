package org.unibl.etf.oop.interfaces.nested2;

import org.unibl.etf.oop.interfaces.nested.A;

public class B implements A.I1 {
	@Override
	public void method1() {
		
	}

	public static void main(String[] args) {
		A.I1 i1 = new B();
		i1.method1();
	}
}
