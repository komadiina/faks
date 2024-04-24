package net.etfbl.collections;

import java.util.Vector;

public class VectorCapacity {

	public static void main(String[] args) throws Exception {
		Vector<Integer> v = new Vector<Integer>();
		System.out.println("Size: " + v.size() + ", Capacity: " + v.capacity());
		for (int i = 0; i < 200; i++) {
			v.add(i);
			System.out.println("Size: " + v.size() + ", Capacity: " + v.capacity());
		}
	}

}
