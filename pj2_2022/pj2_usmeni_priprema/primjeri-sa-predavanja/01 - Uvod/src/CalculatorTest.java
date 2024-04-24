
public class CalculatorTest {
	public static void main(String[] args) {
//		Calculator calc = null;
//		calc.add();
		for(int i=0; i<10; i++) {
			new Calculator();
		}
        
		Calculator c = new Calculator(10, 20);
		System.out.println(c.add());
		System.out.println(c.sub());
		System.out.println(Calculator.numberOfInstances());
		System.out.println(c.numberOfInstances());
	}
}
