package org.unibl.etf.oop.constructorchaining;

public class Calculator { 
	protected int operand1, operand2;
	private static int counter;
	
	Calculator(){											// 1
		this(0);
		System.out.println("No arg constructor...");
	}
	Calculator(int op){									// 2
		this(op, op);
		System.out.println("Constructor with 1 arg...");
	}
	Calculator(int op1, int op2) {					// 3
		operand1 = op1;
		operand2 = op2;
		counter++;
		System.out.println("Constructor with 2 arg...");
	}
	public int add() {
		return operand1 + operand2;
	}
	public int sub() {
		return operand1 - operand2;
	}
	public static int noOfInstances() {
		return counter;
	}
	public static void main(String args[]){	
		Calculator calculator = new Calculator();	// 4
	}
} 
 
