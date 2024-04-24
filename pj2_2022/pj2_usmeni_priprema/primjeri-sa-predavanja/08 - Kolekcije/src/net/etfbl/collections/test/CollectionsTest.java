package net.etfbl.collections.test;

import java.util.*;

public class CollectionsTest {
	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>();
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

		Iterator<Integer> iterator = collection.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());

		collection.stream()
			.forEach(e -> System.out.println(e));
	
	}
}
