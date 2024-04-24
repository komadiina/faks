package org.unibl.etf.threads.yield;

class YieldTest implements Runnable {
	String name = "";
	int numberOfExec;

	public YieldTest(String name, int numberOfExec) {
		this.name = name;
		this.numberOfExec = numberOfExec;
	}

	public void run() {
		System.out.println("Starting: " + name);
		for (int i = 0; i < numberOfExec; i++) {
			if (i % 1000 == 0) {
				System.out.println("Thread " + name + ": " + i / 1_000);
				Thread.yield();
			}
		}
		System.out.println("Ending " + name);
		System.exit(0);
	}
	
	public static void main(String[] args) {
		YieldTest yieldTest1 = new YieldTest("1", 100_000_000);
		YieldTest yieldTest2 = new YieldTest("2", 100_000_000);
		Thread t1 = new Thread(yieldTest1);
		Thread t2 = new Thread(yieldTest2);
		t1.start();
		t2.start();
	}
}
