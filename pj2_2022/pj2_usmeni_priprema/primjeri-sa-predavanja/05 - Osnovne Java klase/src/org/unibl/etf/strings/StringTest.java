package org.unibl.etf.strings;

public class StringTest {
	public static void main(String[] args) {
		String s1 = new String("String");					// 1
		char[] ch = {'S', 't', 'r', 'i', 'n', 'g'};
		String s2 = new String(ch);							// 2
		byte[] by = {83, 116, 114, 105, 110, 103};
		String s3 = new String(by);							// 3
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		String str1 = "123abcdef";
		String str2 = "987abc123";
		System.out.println(str1.regionMatches(3, str2, 3, 4));
		
		
		StringBuilder stringBuilder = new StringBuilder(str1);
		System.out.println(stringBuilder);
		System.out.println(stringBuilder.capacity());
		stringBuilder.trimToSize();
		System.out.println(stringBuilder);
		System.out.println(stringBuilder.capacity());
		stringBuilder.setLength(3);
		System.out.println(stringBuilder);
		System.out.println(stringBuilder.capacity());
		
//		StringBuilder stringBuilder2 = new StringBuilder(str1);
//		System.out.println(stringBuilder2.capacity());
		
		String str3 = "123abcdef";
		System.out.println(str3.contentEquals(str1));
	}
}
