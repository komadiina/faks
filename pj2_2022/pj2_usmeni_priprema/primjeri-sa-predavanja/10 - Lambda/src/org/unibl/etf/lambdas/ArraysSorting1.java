package org.unibl.etf.lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSorting1 {

	public static void main(String[] args) {
		String array[] = { "abc", "def", "ghij", "klmno", "pqrstuv", "whyz" };
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1.length() - s2.length());
			}
		});
		for (String string : array) {
			System.out.println(string);
		}
	}
}

