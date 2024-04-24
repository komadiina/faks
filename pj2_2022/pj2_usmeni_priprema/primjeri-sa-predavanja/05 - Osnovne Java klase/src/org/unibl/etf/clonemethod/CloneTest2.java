package org.unibl.etf.clonemethod;

public class CloneTest2 implements Cloneable {
	int a;
	double b;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneTest2 x1 = new CloneTest2();
		CloneTest2 x2;
		x1.a = 10;
		x1.b = 20;
		x2 = (CloneTest2) x1.clone();
		System.out.println(x1.a + " - " + x1.b);
		System.out.println(x2.a + " - " + x2.b);
		System.out.println(x1==x2);
		x2.a = 100;
		x2.b = 200;
		System.out.println(x1.a + " - " + x1.b);
		System.out.println(x2.a + " - " + x2.b);
		System.out.println(x1==x2);
	}
}
