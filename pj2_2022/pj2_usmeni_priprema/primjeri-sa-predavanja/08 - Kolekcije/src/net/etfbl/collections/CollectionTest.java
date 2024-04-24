package net.etfbl.collections;

import java.util.*;

public class CollectionTest {
	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>();
		Collection<Integer> collection2 = new ArrayList<Integer>();
		collection.add(1);
		collection.add(2);
		collection.add(3);
		collection.add(4);
		collection.add(5);
		collection.add(6);
		collection.add(7);
		collection.add(8);
		collection.add(9);
		collection.add(10);
		for (Integer i : collection)
			System.out.println(i);
		System.out.println(collection.contains(5));
		collection.remove(5);
		for (Integer i : collection)
			System.out.println(i);
		System.out.println(collection.contains(5));

		Iterator<Integer> iterator = collection.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());

		System.out.println("==============stream=================");

		collection.stream()
			.forEach(e -> System.out.println(e));
		System.out.println("==============stream 2=================");
		collection.stream()
			.filter(e -> e > 5)
			.forEach(e -> System.out.println(e));

		System.out.println("===============================");
		Object array[] = collection.toArray();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println("===============================");
		Integer integerArray[] = collection.toArray(new Integer[0]);
		for (int i = 0; i < integerArray.length; i++) {
			System.out.println(integerArray[i]);
		}
		System.out.println("===============================");
		collection2.add(1);
		collection2.add(2);
		collection2.add(3);
		for (Integer i : collection)
			System.out.println(i);
		collection.addAll(collection2);
		System.out.println("===");
		for (Integer i : collection)
			System.out.println(i);
		System.out.println("===");
		collection.retainAll(collection2);
		for (Integer i : collection)
			System.out.println(i);
		System.out.println("===");
		collection.removeAll(collection2);
		for (Integer i : collection)
			System.out.println(i);
		System.out.println("===");
		// System.out.println(collection.contains(5));
		// collection.remove(5);
		// System.out.println(collection.contains(5));
		// for(Integer i: collection)
		// System.out.println(i);
		//// Iterator<Integer> iterator = collection.iterator();
		//// while(iterator.hasNext())
		//// System.out.println(iterator.next());
		// System.out.println(collection.isEmpty());
	}
}
