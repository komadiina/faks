package net.etfbl.collections;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		NavigableSet<Integer> ns = new TreeSet<Integer>();
		ns.add(1);
		ns.add(9);
		ns.add(6);
		ns.add(35);
		ns.add(12);
		for (Iterator<Integer> it = ns.iterator(); it.hasNext();) {
			Integer integer = (Integer) it.next();
			System.out.println(integer);
		}
		System.out.println("==========");
		for (Iterator<Integer> it = ns.descendingIterator(); it.hasNext();) {
			Integer integer = (Integer) it.next();
			System.out.println(integer);
		}
	}

}
