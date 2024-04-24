package org.unibl.etf.oop;

public class B {			// 1
	int x = 0, y = 0;
	public B() {
		// TODO Auto-generated constructor stub
	}
	B(int a, int b){
		x = a;
		y = b;
	}
	public int add(){
		return x + y;
	}
	public static void main(String args[]){
		B b = new B(1,2);
		C c = new C();
	}
}

class C extends B{			// 2
	C(int a, int b) {
		super(a, b);
	}

	public C() {
		// TODO Auto-generated constructor stub
	}

	public int add(){
		return y+x;
	}
}


