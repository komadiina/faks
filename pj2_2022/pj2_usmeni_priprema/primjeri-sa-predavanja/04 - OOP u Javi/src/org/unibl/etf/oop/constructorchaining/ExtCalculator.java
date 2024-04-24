package org.unibl.etf.oop.constructorchaining;

public class ExtCalculator extends Calculator {
	protected int operand3, operand4;

	ExtCalculator() {														// 1
		super();															
		System.out.println("Ext - No args constructor...");
	}
//	ExtCalculator(){														// 2
//		System.out.println("Ext - No args constructor...");
//	}
//	ExtCalculator(int op1, int op2, int op3, int op4) {					// 3
//		super(op1, op2);														// 4
//		System.out.println("Ext - Constructor with 4 args...");
//	}
	
	public static void main(String args[]){
		ExtCalculator calculator = new ExtCalculator();
	}
}
