package net.etfbl.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsChangeTest {
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(3);
		ll.add(7);
		ll.add(9);
		ll.add(6);
		ll.add(7);
		iterate(ll);
		Collections.replaceAll(ll, 7, 8);
		iterate(ll);
		Collections.addAll(ll, 15, 16, 17);
		iterate(ll);
	}

	private static void iterate(LinkedList<Integer> ll) {
		for (Iterator<Integer> it = ll.iterator(); it.hasNext();)
			System.out.print(" " + it.next());
		System.out.println("\n ===========");
	}
}
