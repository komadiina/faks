package net.etfbl.lambdas.strings;

public class Test {
	public int instanceVariable = 0;
	public static int staticVariable = 0;
	static String stringOperation(StringFunction sf, String s) {
		return sf.function(s);
	}

	public static void main(String[] args) {
		String inputString = "This is test string";
		String outputString;
		
		outputString = stringOperation(new StringFunction() {
			@Override
			public String function(String s) {
				return s.substring(1);
			}
		}, inputString);
		System.out.println(outputString);

		outputString = stringOperation(s -> s.substring(2), inputString);
		System.out.println(outputString);

		outputString = stringOperation(s -> {
			String s1 = s.substring(0,1);
			String sn = s.substring(s.length()-1);
			int i = staticVariable;
			return s1+sn;
		}, inputString);
		System.out.println(outputString);

		outputString = stringOperation(StringOperations::reverseStringStatic, inputString);
		System.out.println(outputString);
		
		StringOperations stringOperations = new StringOperations();
		outputString = stringOperation(stringOperations::reverseStringInstance, inputString);
		System.out.println(outputString);
		
		
		StringComparator strArray[] = {new StringComparator("abc"), 
				new StringComparator("def"), 
				new StringComparator("a"), 
				new StringComparator("ertfg"), 
				new StringComparator("123456"), 
				new StringComparator("1234567890")
				};
		int sameSizeStrings = count(strArray, StringComparator::sameLength, new StringComparator("111"));
		System.out.println(sameSizeStrings);
		int longer = count(strArray, StringComparator::isLongerThen, new StringComparator("111"));
		System.out.println(longer);

	}
	
	static int count(StringComparator[] stringArray, StringFunction2 sf, StringComparator s) {
		int count = 0;
		for (int i = 0; i < stringArray.length; i++) {
			if(sf.function(stringArray[i], s)) {
				count++;
			}
		};
		return count;
	}

}
