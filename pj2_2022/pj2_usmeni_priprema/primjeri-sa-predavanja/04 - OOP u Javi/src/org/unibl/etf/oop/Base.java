package org.unibl.etf.oop;

import java.io.IOException;
import java.sql.SQLException;

public class Base {
	public void method1(){										// 1
		System.out.println("method1, Base class");
	}
	public void method2(){										// 2
		System.out.println("method2, Base class");
	}
	protected void method3() throws IOException, SQLException{	// 3
		System.out.println("method3, Base class");
	}
	public static void staticMethod() {
		
	}
	public Base createInstance(){
		return new Base();
	}
}

