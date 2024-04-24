package net.etfbl.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
		lhm.put(1, "1");
		lhm.put(2, "2");
		lhm.put(3, "3");
		lhm.put(4, "4");
		Collection<String> coll = lhm.values();
		System.out.print("Obilazak:");
		for (Iterator<String> it = coll.iterator(); it.hasNext();) {
			String string = (String) it.next();
			System.out.print(" " + string);
		}
		System.out.println("\n=========");
		LinkedHashMap<Integer, String> lhm2 = new LinkedHashMap<Integer, String>(
				16, 0.75f, true);
		lhm2.put(1, "1");
		lhm2.put(2, "2");
		lhm2.put(3, "3");
		lhm2.put(4, "4");
		Collection<String> coll2 = lhm2.values();
		System.out.print("Prvi obilazak:");
		for (Iterator<String> it = coll2.iterator(); it.hasNext();) {
			String string = (String) it.next();
			System.out.print(" " + string);
		}
		System.out.print("\n" + lhm2.get(1));
		System.out.print("\n" + lhm2.get(3));
		System.out.print("\n" + lhm2.get(2));
		coll2 = lhm2.values();
		System.out.print("\nDrugi obilazak:");
		for (Iterator<String> it = coll2.iterator(); it.hasNext();) {
			String string = (String) it.next();
			System.out.print(" " + string);
		}
	}
}
