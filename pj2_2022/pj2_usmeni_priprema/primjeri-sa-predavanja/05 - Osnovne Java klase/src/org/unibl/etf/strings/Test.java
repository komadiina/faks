package org.unibl.etf.strings;

public class Test {

	public static void main(String[] args) {
//		String s1 = "Java Programming Language";
//		String s2 = "Java Development Kit";
//		
//		int length = "Java Programming Language".length();
//		int hash = "Java Development Kit".hashCode();

		String s1 = "Java Programming Language";
		String s2 = "Java Programming Language";
		String s3 = "Java " + "Programming Language";

		String temp = "Java ";
		String s4 = temp + "Programming Language";

		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
	}

}
