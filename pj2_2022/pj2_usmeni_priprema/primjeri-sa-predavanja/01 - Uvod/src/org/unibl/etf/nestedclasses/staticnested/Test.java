package org.unibl.etf.nestedclasses.staticnested;

import org.unibl.etf.nestedclasses.staticnested.Outer;
import org.unibl.etf.nestedclasses.staticnested.Outer.Nested;

public class Test {

	public static void main(String[] args) {
		Outer.Nested nested = new Outer.Nested();
		nested.method();
		Nested n = new Nested();
	}

}
