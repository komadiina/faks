package org.unibl.etf.equalsandhashcodemethods;

import java.util.HashSet;

public class SearchingPhones {

	public static void main(String[] args) {
		HashSet<Phone> phones = new HashSet<Phone>();
		Phone p1 = new Phone("Samsung", "S8");
		Phone p2 = new Phone("Samsung", "S9");
		phones.add(p1);
		phones.add(p2);
		Phone p3 = new Phone("Samsung", "S9");
		boolean res = phones.contains(p3);
		System.out.println(res);

		System.out.println(p1.equals(p3));
		System.out.println(p2.equals(p3));
	}
}

