package org.unibl.etf.lambdas;

class HelloBase {
	public void sayHello() {
		System.out.println("Hello from HelloBase!");
	}
	public int sayHello2() {
		return 1;
	}
}

class HelloSub extends HelloBase {
	public void sayHello() {
//		A a = new A();
//		Thread t = new Thread(a::method);
		Thread t = new Thread(super::sayHello);
		t.start();
	}
	
	public static void main(String[] args) {
		HelloSub helloSub = new HelloSub();
		helloSub.sayHello();
	}
}


class A {
	public String method() {
		return "s";
	}
}