package net.etfbl.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(3);
		al.add(7);
		al.add(9);
		al.add(6);
		al.add(7);
		
		for (Integer integer : al) {
			System.out.print(integer + " ");
		}
		System.out.println();
		for (Iterator<Integer> it = al.iterator(); it.hasNext();) {
			Integer integer = (Integer) it.next();
			System.out.print(integer + " ");
		}
		System.out.println();
		al.remove(2);
		for (int i = 0; i < al.size(); i++) {
			System.out.println("pozicija " + i + ": " + al.get(i));
		}
	}
}
