package net.etfbl.collections;

import java.util.Hashtable;

public class HashtableTest {
	public static void main(String[] args) {
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		ht.put(1, "1");
		ht.put(2, "2");
		ht.put(3, "3");
		ht.put(4, "4");
		System.out.println("Velicina: " + ht.size());
		System.out.println("Kljuc 3: " + ht.containsKey(3));
		System.out.println("Vrijednost 2: " + ht.containsValue("2"));
		ht.remove(3);
		System.out.println("Velicina: " + ht.size());
	}
}
