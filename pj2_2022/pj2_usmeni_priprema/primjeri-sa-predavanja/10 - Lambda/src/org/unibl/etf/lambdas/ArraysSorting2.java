package org.unibl.etf.lambdas;


import java.util.Arrays;

public class ArraysSorting2 {
	
	public static void main(String[] args) {
		String array[] = { "abc", "def", "ghij", "klmno", "pqrstuv", "whyz" };
		Arrays.sort(array, (String s1, String s2) -> {
			return (s1.length() - s2.length());
		});
		for (String string : array) {
			System.out.println(string);
		}
	}
}

