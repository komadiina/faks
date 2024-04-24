package org.unibl.etf.threads.join;

public class JoinTest {
	public static void main(String[] args) {
		System.out.println("Main thread - start");
		MyThread myThread = new MyThread(); // 1
		myThread.start(); // 2
		try {
			myThread.join(); // 3
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread - end");
	}
}

class MyThread extends Thread {
	public void run() { // 4
		System.out.println("MyThread - start");
		for (int i = 1; i <= 10; i++) {
			System.out.println("MyThread: " + i);
		}
		System.out.println("MyThread - end");
	}
}
