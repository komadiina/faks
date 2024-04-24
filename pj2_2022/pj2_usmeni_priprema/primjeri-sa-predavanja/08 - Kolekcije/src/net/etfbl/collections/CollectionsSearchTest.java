package net.etfbl.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsSearchTest {
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(3);
		ll.add(7);
		ll.add(9);
		ll.add(6);
		ll.add(7);
		Collections.sort(ll);
		for (Iterator<Integer> it = ll.iterator(); it.hasNext();)
			System.out.print((Integer) it.next() + " ");
		System.out.println("\nPretraga 6: " + Collections.binarySearch(ll, 6));
		System.out.println("Pretraga 2: " + Collections.binarySearch(ll, 2));
		System.out.println("Max: " + Collections.max(ll));
		System.out.println("Min: " + Collections.min(ll));
	}
}
