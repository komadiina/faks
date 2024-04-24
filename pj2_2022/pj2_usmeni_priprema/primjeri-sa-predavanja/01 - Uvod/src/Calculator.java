public class Calculator {
	protected double operand1;
	protected double operand2;
	private static int counter = 0;
	
	public Calculator() {
		operand1 = operand2 = 0;
		counter++;
	}
	public Calculator(double operand1, double operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
		counter++;
	}
	
	public double add() {
		return operand1 + operand2;
	}
	
	public double sub() {
		return operand1 - operand2;
	}
	
	public static int numberOfInstances() { 
		return counter;
	}
}
