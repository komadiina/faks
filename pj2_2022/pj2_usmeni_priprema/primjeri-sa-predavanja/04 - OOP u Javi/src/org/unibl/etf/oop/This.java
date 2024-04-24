package org.unibl.etf.oop;

public class This {
	private int number = 1;					// 1
	
	public void method(){					// 2
		long number = 1;						// 3
		long temp = number + this.number;	// 4
		System.out.println(temp);
	}
}

