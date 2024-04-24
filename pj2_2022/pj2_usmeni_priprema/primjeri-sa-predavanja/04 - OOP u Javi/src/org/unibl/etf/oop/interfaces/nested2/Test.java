package org.unibl.etf.oop.interfaces.nested2;

import org.unibl.etf.oop.interfaces.nested.A;

public class Test {

	public static void main(String[] args) {
		A a = new A();
		A.X x = a.new X();
	}

}
