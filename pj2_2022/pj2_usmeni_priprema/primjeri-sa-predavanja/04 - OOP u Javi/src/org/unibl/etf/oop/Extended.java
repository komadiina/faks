package org.unibl.etf.oop;

import java.io.IOException;
import java.sql.SQLException;

public class Extended extends Base {
	public void method1() {										// 1
		super.method1();										// 2
		System.out.println("method1, Extended class");
	}

//	public void method3() throws Exception{						// 2
//		System.out.println("method3, Extended class");
//	}

	public void method3(){										// 3
		System.out.println("method3, Extended class");
	}

//	public void method3() throws IOException, SQLException{		// 4
//		System.out.println("method3, Extended class");
//	}		
//	public void method3() throws IOException {					// 5
//		System.out.println("method3, Extended class");	
//	}
//	
//	public void method3() throws SQLException {					// 6
//		System.out.println("method3, Extended class");
//	}
	
	public static void staticMethod() {
		
	}

	@Override
	public Extended createInstance(){
		return new Extended();
	}

}
