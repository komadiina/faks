package org.unibl.etf.lambdas;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysSorting4 {
	
	public static void main(String[] args) {
		String array[] = { "abc", "def", "ghij", "klmno", "pqrstuv", "whyz" };
		Arrays.sort(array, (s1, s2) -> s1.length() - s2.length());
		Stream.of(array).forEach(System.out::println);
//		Stream.of(array).parallel().forEach(System.out::println);
	}
}