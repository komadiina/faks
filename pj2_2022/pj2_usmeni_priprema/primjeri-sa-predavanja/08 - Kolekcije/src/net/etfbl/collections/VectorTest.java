package net.etfbl.collections;

import java.util.Iterator;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		int i = 0;
		Vector<Integer> vector = new Vector<Integer>();
		vector.add(1);
		vector.add(3);
		vector.add(7);
		vector.add(9);
		vector.add(6);
		vector.add(7);
		vector.add(10);
		System.out.println(vector.firstElement());
		System.out.println(vector.lastElement());
		for (Iterator<Integer> it = vector.iterator(); it.hasNext();) {
			Integer integer = (Integer) it.next();
			System.out.println(integer);
			it.remove();
//			vector.remove(0);
		}
//		System.out.println(vector.firstElement());
	}
}
