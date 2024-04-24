package net.etfbl.collections;

import java.util.Arrays;

public class ArraysSortTest {
	public static void main(String[] args) {
		int array[] = {4, 7, 2, 3, 9, 7, 6};
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
