package net.etfbl.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(3);
		ll.add(7);
		ll.add(9);
		ll.add(6);
		ll.add(7);
		for (Iterator<Integer> it = ll.iterator(); it.hasNext();) {
			Integer integer = (Integer) it.next();
			System.out.println(integer);
		}
		ll.remove(2);
		for (int i = 0; i < ll.size(); i++) {
			System.out.println("pozicija " + i + ": " + ll.get(i));
		}
	}
}
