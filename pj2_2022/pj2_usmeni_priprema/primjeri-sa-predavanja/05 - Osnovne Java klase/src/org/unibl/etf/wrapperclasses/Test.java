package org.unibl.etf.wrapperclasses;

public class Test {

	public static void main(String[] args) {
//		Boolean b1 = Boolean.valueOf(true);
//		Boolean b2 = true;
//		
//		Character c = Character.valueOf('t');
//		Boolean b = Boolean.valueOf(true);
//		Integer i = Integer.valueOf(1);
//		Long l = Long.valueOf(9L);
//		Float f = Float.valueOf(1.2f);
//		Short s = Short.valueOf((short) 1);
//		Byte bb = Byte.valueOf((byte)1);	

//		Double d1 = Double.valueOf(1.25);
//		Double d2 = Double.valueOf("1.25");
//		Boolean b1 = Boolean.valueOf(true);
//		Boolean b2 = Boolean.valueOf("true");
//		Float f1 = Float.valueOf(1.2f);
//		Float f2 = Float.valueOf("1.2f");
//		Short s1 = Short.valueOf((short) 1);
//		Short s2 = Short.valueOf("1");
//		System.out.println(f1);
//		System.out.println(f2);
//		
//		Integer i = Integer.valueOf("1010", 2);
//		Integer i2 = Integer.valueOf("012", 8);
//		Integer i3 = Integer.valueOf("10", 10);
//		Integer i4 = Integer.valueOf("A", 16);
		
//		String str1 = d1.toString(); 
//		String str2 = d2.toString();
//		String str3 = b1.toString();
//		String str4 = b2.toString();
//		String str5 = f1.toString();
//		String str6 = f2.toString();
//		String str7 = s1.toString();
//		String str8 = s2.toString();
//		
//		String cs = Character.toString('t');
//		String bs = Boolean.toString(true);
//		String is = Integer.toString(1);
//		String ds = Double.toString(1.25);
//		String ls = Long.toString(9);
//		String fs = Float.toString(1.0f);
//		String ss = Short.toString((short) 1);
//		String bbs = Byte.toString((byte) 1);

		Double d1 = 1.25, d2 = 1.26;
		boolean test = d1.equals(d2);
		System.out.println(test);
//		System.out.println(d2.compareTo(d2));
		Integer i1 = 1, i2 = 1;
		test = i1.equals(i2);
		System.out.println(test);

		int i = Integer.parseInt("1");
		double d = Double.parseDouble("1.25");
		long l = Long.parseLong("9");
		float f = Float.parseFloat("1.0");
		short s = Short.parseShort("1");
		byte bb = Byte.parseByte("1");
		System.out.println(i);


	}

}
