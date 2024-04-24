package org.unibl.etf.calculator;

public class Calculator {
	protected double operand1;
	protected double operand2;
	
	public Calculator() {
		operand1 = 0;
		operand2 = 0;
	}
	public Calculator(double operand1, double operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	public double add() {
		return operand1 + operand2;
	}
	
	public double sub() {
		return operand1 - operand2;
	}
}