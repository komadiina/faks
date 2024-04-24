package org.unibl.etf.equalsandhashcodemethods;

import java.util.HashSet;

public class Phone {
	String manufacturer;
	String model;

	public Phone(String manufacturer, String model) {
		this.manufacturer = manufacturer;
		this.model = model;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Phone) {
			Phone t = (Phone) obj;
			if (manufacturer.equals(t.manufacturer) && model.equals(t.model)) {
				return true;
			}
		}
		return false;
	}

	public int hashCode() {
		return manufacturer.hashCode() + model.hashCode();
	}

//	public int hashCode() {
//		int hash = 3;
//		hash = 7 * hash + manufacturer.hashCode();
//		hash = 7 * hash + model.hashCode();
//		return hash;
//	}


	public static void main(String[] args) {
		Phone t1 = new Phone("Samsung", "S8"); // 1
		Phone t2 = new Phone("Samsung", "S9"); // 2
		System.out.println(t1.equals(t2)); // 3
		Phone t3 = new Phone("Samsung", "S9"); // 4
		System.out.println(t2.equals(t3));
		System.out.println("===========");
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		System.out.println(t3.hashCode());
		HashSet<Phone> phones = new HashSet<Phone>();
		phones.add(t1);
		phones.add(t2);
		System.out.println(phones.contains(t3));
	}
}
