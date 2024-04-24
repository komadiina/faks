package net.etfbl.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=1; i<=10; i++)
			hs.add(i);
		for (Iterator<Integer> it = hs.iterator(); it.hasNext();) {
			Integer integer = (Integer) it.next();
			System.out.println(integer);
		}
		System.out.println("=========");
		LinkedHashSet<Integer> hs2 = new LinkedHashSet<Integer>();
		for(int i=1; i<=10; i++)
			hs2.add(i);
		for (Iterator<Integer> it = hs2.iterator(); it.hasNext();) {
			Integer integer = (Integer) it.next();
			System.out.println(integer);
		}
		System.out.println("=========");
		
		Set<String> immutableHS = Set.of("a", "b", "c", "d");
//		immutableHS.add("e");
		for (String string : immutableHS) {
			System.out.println(string);
		}
	}
}
