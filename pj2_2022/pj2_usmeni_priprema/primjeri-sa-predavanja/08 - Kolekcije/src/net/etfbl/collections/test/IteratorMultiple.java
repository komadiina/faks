package net.etfbl.collections.test;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorMultiple {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(3);
		al.add(7);
		al.add(9);
		al.add(6);
		al.add(7);
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(11);
		al2.add(33);
		al2.add(77);
		al2.add(99);
		al2.add(66);
		al2.add(77);
		for (Iterator<Integer> iterator1 = al.iterator(), iterator2 = al2.iterator(); iterator1.hasNext()
				&& iterator2.hasNext();) {
			System.out.println("First: " + iterator1.next());
			System.out.println("Second: " + iterator2.next());
			System.out.println("==========");
		}
	}

}
