package net.etfbl.collections;

import java.util.Arrays;

public class ArraysSearchTest {
	public static void main(String[] args) {
		int array[] = { 4, 7, 2, 3, 9, 7, 6 };
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		System.out.println("Pretraga 3: " + Arrays.binarySearch(array, 3));
		System.out.println("Pretraga 5: " + Arrays.binarySearch(array, 5));
	}
}
