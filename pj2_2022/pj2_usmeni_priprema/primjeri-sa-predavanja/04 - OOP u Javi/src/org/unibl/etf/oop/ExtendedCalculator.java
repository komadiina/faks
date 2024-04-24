package org.unibl.etf.oop;

import org.unibl.etf.calculator.Calculator;

public class ExtendedCalculator extends Calculator {
	public ExtendedCalculator() {
		super();
	}

	ExtendedCalculator(double operand1, double operand2) {
		super(operand1, operand2);
	}

	public double multiply() { 				// 1
		return operand1 * operand2;
	}

	public double divide() { 				// 2
		return operand1 / operand2;
	}
	
	public static void main(String[] args) {
//		ExtendedCalculator ec = new ExtendedCalculator(10, 20);
//		double sum = ec.add();
//		double mul = ec.multiply();
//		double div = ec.divide();
		
		Calculator calculator = new ExtendedCalculator(10, 20);
		double sum = calculator.add();
//		double mul = calculator.multiply();
		double div = ((ExtendedCalculator) calculator).divide();
		System.out.println(sum);
		System.out.println(div);
	}
}
