package org.unibl.etf.object;

public class Wrapper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer i = 1;
		System.out.println(i);
		Integer i2 = 2;
		System.out.println(i2);
		int i22 = i2;
		System.out.println(i22);

		System.out.println("===== valueOf =====");
		Integer x2 = Integer.valueOf("10100", 2);
		Integer x8 = Integer.valueOf("24", 8);
		Integer x10 = Integer.valueOf("20", 10);
		Integer x16 = Integer.valueOf("14", 16);
		System.out.println(x2 + "  " + x8 + "  " + x10 + "  " + x16);

		System.out.println("===== compareTo =====");
		System.out.println(i.compareTo(i2));
		System.out.println(i2.compareTo(i2));
		System.out.println(i2.compareTo(i));
		

		System.out.println("===== parseInt =====");
		System.out.println(Integer.parseInt("10"));
		
	}

}
