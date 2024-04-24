package org.unibl.etf.lambdas.instancerefmethods;

public class InstanceMethodReference {
	public static void main(String[] args) {
		StringOperations strOp = new StringOperations();
		String test = "test";
		String res = stringOp(t -> {							// 1
			String result = "";
			for (int i = t.length() - 1; i >= 0; i--) {
				result += t.charAt(i);
			}
			return result;
		}, test);
		System.out.println(res);
		res = stringOp(strOp::reverse, test);				// 2
		System.out.println(res);
	}
	static String stringOp(StringFunction sf, String s) {	// 3
		return sf.function(s);
	}
}

class StringOperations {										// 4
	public String reverse(String s) {							// 5
		String result = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		return result;
	}
}

interface StringFunction {										// 6
	public String function(String s);							// 7
}
