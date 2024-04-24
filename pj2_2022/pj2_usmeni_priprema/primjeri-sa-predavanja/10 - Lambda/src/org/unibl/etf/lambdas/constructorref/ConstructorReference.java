package org.unibl.etf.lambdas.constructorref;

public class ConstructorReference {
	public static void main(String[] args) {
		Function f = Temperature::new;						// 1
		Temperature temp = f.function(30);					// 2
		System.out.println(temp.getValue());
	}
}
class Temperature {												// 3
	int value;
	public Temperature() {
		value = 0;
	}	
	public Temperature(int temp){								// 4
		value = temp;
	}
	public int getValue() {
		return value;
	}
}
interface Function {											// 5
	Temperature function(int t);								// 6
}

interface Function2 {
	Temperature function();
}
