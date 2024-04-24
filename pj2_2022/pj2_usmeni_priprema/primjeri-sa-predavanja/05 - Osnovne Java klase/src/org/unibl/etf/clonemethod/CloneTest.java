package org.unibl.etf.clonemethod;

public class CloneTest { // implements Cloneable
	int a;
	double b;
	
	CloneTest cloneTest(){
		try {
			return (CloneTest) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Cloning not supported");
			return this;
		}
	}
	
	public static void main(String[] args) {
		CloneTest x1 = new CloneTest();
		CloneTest x2;
		x1.a = 10;
		x1.b = 20;
		x2 = x1.cloneTest();
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
