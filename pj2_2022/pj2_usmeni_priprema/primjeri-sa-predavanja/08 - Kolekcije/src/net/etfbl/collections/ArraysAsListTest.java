package net.etfbl.collections;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListTest {
	public static void main(String[] args) {
		Integer array[] = {4, 7, 2, 3, 9, 7, 6};
		List<Integer> list = Arrays.asList(array);
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
	}
}
