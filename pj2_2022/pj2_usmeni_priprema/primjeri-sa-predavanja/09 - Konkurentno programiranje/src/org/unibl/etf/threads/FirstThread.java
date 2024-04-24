package org.unibl.etf.threads;

public class FirstThread extends Thread {

public void run() { 										// 1
		System.out.println("Thread: " + getId()); 			// 2
	}

	public static void main(String[] args) {
		System.out.println("Main thread - start");
		FirstThread thread1 = new FirstThread(); 			// 3
		thread1.start(); 										// 4
		FirstThread thread2 = new FirstThread(); 			// 5
		thread2.start(); 										// 6
		FirstThread thread3 = new FirstThread(); 			// 7
		thread3.start(); 										// 8
		System.out.println("Main thread - end");
	}
}

