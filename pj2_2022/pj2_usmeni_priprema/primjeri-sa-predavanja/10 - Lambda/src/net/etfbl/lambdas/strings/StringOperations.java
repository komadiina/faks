package net.etfbl.lambdas.strings;

public class StringOperations {
	public static String reverseStringStatic(String s) {
		String result = "";
		int i = 0;
		for (i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		return result;
	}
	
	public String reverseStringInstance(String s) {
		String result = "";
		int i = 0;
		for (i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		return result;
	}
}
