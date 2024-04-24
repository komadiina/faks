package org.unibl.etf.oop;

public class MaskBase {
	int number = 0;								// 1
	String string = "test";						// 2
	public static void staticMethod(){			// 3
		System.out.println("Static method, base class");
	} 
}

class MaskExtended extends MaskBase{
	int number = 1;								// 4
	static int string = 2;						// 5
	public void metoda(){		
		int tmp = super.number + number;		// 6
		String s = super.string + string;		// 7 
		MaskBase.staticMethod();				// 8
		super.staticMethod();					// 9
	}
	public static void staticMethod(){			// 10
		MaskBase.staticMethod();				// 11
		System.out.println("Static method, extended class");
	}
}


