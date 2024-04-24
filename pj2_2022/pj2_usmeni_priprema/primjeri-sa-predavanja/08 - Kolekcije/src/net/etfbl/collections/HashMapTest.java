package net.etfbl.collections;

import java.util.HashMap;

public class HashMapTest { 
	public static void main(String[] args) { 
		HashMap<Integer, String> hm = new HashMap<>(); // 1 
		hm.put(1, "1"); // 2 
		hm.put(2, "2"); // 3 
		hm.put(4, "4"); // 4 
		hm.put(3, "3"); // 5 
		System.out.println(hm.get(3));
		hm.putIfAbsent(5, "5"); // 6 
		hm.putIfAbsent(3, "33"); // 7
		System.out.println(hm.get(3)); 
		System.out.println("Size: " + hm.size()); // 8 
		System.out.println("Key 3: " + hm.containsKey(3));// 9 
		System.out.println("Value 2: " + hm.containsValue("2")); // 10 
		hm.remove(3); // 11 
		System.out.println("Size: " + hm.size()); // 12 } }
	}
}
