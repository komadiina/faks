
public class GenericInterfaceTest {
	public static void main(String[] args) {
//		NumberInterface ni;
//		ni = () -> 11;
//		System.out.println(ni.getNumber());
		
		GenericNumberInterface<Double> gni;
		gni = () -> 12.3d;
		System.out.println(gni.getNumber());
		
		double doubleValue = testMethod(() -> 11);
		System.out.println(doubleValue);
		
		double doubleValue2 = testMethod2(gni);
		System.out.println(doubleValue2);
	}
//	
//	public static void main(String[] args) {				
//		double doubleValue = testMethod(() -> 11);			// 1
//		System.out.println(doubleValue);
//	}

	
	static double testMethod(NumberInterface ni) {
		double x = ni.getNumber() * 2;
		return x;
	}

	static double testMethod2(GenericNumberInterface<Double> gni) {
		return gni.getNumber();
	}
}



