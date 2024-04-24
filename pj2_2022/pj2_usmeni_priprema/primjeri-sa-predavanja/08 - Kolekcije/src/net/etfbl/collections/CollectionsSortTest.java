package net.etfbl.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsSortTest {
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(3);
		ll.add(7);
		ll.add(9);
		ll.add(6);
		ll.add(7);
		iterate(ll);
		Collections.sort(ll);
		iterate(ll);
		Collections.reverse(ll);
		iterate(ll);
		Collections.rotate(ll, 3);
		iterate(ll);
		Collections.shuffle(ll);
		iterate(ll);
	}

	private static void iterate(LinkedList<Integer> ll) {
		for (Iterator<Integer> it = ll.iterator(); it.hasNext();)
			System.out.print(" " + it.next());
		System.out.println("\n ===========");
	}
}
