package org.unibl.etf.lambdas.staticrefmethods;

import java.util.function.UnaryOperator;

public class StaticMethodReference {

	public static void main(String[] args) {
		String test = "PJ2";
		String res = stringOp(t -> {
			String result = "";
			for (int i = t.length() - 1; i >= 0; i--) {
				result += t.charAt(i);
			}
			return result;
		}, test);
		System.out.println(res);
		res = stringOp(StringOperations::reverse, test);
		System.out.println(res);
	}

	static String stringOp(StringFunction sf, String s) {
		return sf.function(s);
	}

//	static String stringOp(UnaryOperator<String> sf, String s) {
//		return sf.apply(s);
//	}
}

class StringOperations {
	public static String reverse(String s) {
		String result = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		return result;
	}
}

interface StringFunction {
	public String function(String s);
}
