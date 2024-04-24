package org.unibl.etf.lambdas.variablecapture;

public class VariableCapture {
	private int instanceVariable = 0;						// 1
	private static int staticVariable = 0;				// 2
	
	public static void main(String[] args) {
		VariableCapture varCapture = new VariableCapture();
		varCapture.method(10);
	}
	void method(int i) {
		int localVariable = 10;								// 3
		TestI var = (n) -> {								// 4
			int result = localVariable * n;				// 5	
			instanceVariable++;								// 6
			staticVariable++;								// 7
			System.out.println(localVariable);
			System.out.println(instanceVariable);
			System.out.println(staticVariable);
//			localVariable++;									// 8
			this.method2();									// 9
//			int localVariable;								// 10
			return result;
		};
//		localVariable++;										// 11
		System.out.println(var.function(10));
	}
	void method2() {
		System.out.println("method 2");
	}
}

interface TestI {
	int function(int i);
}

