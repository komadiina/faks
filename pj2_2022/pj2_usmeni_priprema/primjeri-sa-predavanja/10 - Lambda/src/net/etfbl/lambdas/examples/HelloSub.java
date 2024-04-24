package net.etfbl.lambdas.examples;

class HelloBase {
	public void sayHello() {
		System.out.println("Hello from HelloBase!");
	}
}

class HelloSub extends HelloBase {
	public void sayHello() {
		Thread t = new Thread(super::sayHello);
		t.start();
	}
	
	public static void main(String[] args) {
		HelloSub helloSub = new HelloSub();
		helloSub.sayHello();
	}
}