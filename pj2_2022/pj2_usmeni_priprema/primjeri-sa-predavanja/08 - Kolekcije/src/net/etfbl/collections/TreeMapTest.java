package net.etfbl.collections;

import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		tm.put(10, "10");
		tm.put(20, "20");
		tm.put(30, "30");
		tm.put(50, "50");
		System.out.println("prvi kljuc: " + tm.firstKey());
		System.out.println("posljednji kljuc: " + tm.lastKey());
		System.out.println("najvece mapiranje sa kljucem <= 21: "
				+ tm.floorEntry(21));
		System.out.println("najvece mapiranje sa kljucem >= 21: "
				+ tm.ceilingEntry(21));
		System.out.println("prvo mapiranje: " + tm.firstEntry());
		System.out.println("posljednje mapiranje: " + tm.lastEntry());
	}
}
