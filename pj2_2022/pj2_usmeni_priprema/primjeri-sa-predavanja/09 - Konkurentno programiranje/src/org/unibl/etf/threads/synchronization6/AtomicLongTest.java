package org.unibl.etf.threads.synchronization6;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicLongTest {
	public static void main(String[] args) {
		new MyThread("A").start();
		new MyThread("B").start();
		new MyThread("C").start();
	}
}
class MyThread extends Thread {
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	public void run() {
		System.out.println("Started: " + name);
		for (int i = 0; i < 5; i++){
			System.out.println(name + ": " + Shared.number.incrementAndGet());
		}
	}
}

class Shared {
	static AtomicInteger number = new AtomicInteger(0);
}

