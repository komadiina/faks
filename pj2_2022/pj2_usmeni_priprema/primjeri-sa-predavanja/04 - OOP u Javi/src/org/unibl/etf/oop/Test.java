package org.unibl.etf.oop;

import java.io.IOException;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws IOException, SQLException {
		Base b = new Base();
		Extended e = new Extended ();

		b.method1();
		b.method2();
		b.method3();

		e.method1();
		e.method2();
		e.method3();
	}
}
