package org.unibl.etf.strings;

public class StringTest2 {
	public static void main(String[] args) {
		String string = "string";
		System.out.println(System.identityHashCode(string));
		String s1 = "test string";
		String s2 = "test string";
		String s3 = "test" + " string";
		String s4 = "test" + " " + string;
		String s5 = new String("test string");
		String s6 = ("test " + string).intern();
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);
		System.out.println(s1 == s5);
		System.out.println(s1 == s6);
		
		string += "a";
		System.out.println(System.identityHashCode(string));
		string = string.concat("b");
		System.out.println(System.identityHashCode(string));
	}

}
