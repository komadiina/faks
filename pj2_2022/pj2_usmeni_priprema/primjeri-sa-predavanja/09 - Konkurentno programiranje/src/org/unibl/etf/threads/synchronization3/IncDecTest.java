package org.unibl.etf.threads.synchronization3;

import java.util.concurrent.Semaphore;
 
public class IncDecTest { 							
	public static void main(String args[]) {
		Semaphore sm = new Semaphore(1);						// 1
		Counter cnt = new Counter();							// 2
		Incrementator inc = new Incrementator(cnt, 3, sm);		// 3
		Decrementator dec = new Decrementator(cnt, 3, sm);		// 4
		inc.start();											// 5
		dec.start();											// 6
	}
}

class Incrementator extends Thread {
	private Counter counter;
	private int number;
	private Semaphore semaphore;

	public Incrementator(Counter counter, int number, Semaphore sem) {
		this.counter = counter;
		this.number = number;
		this.semaphore = sem;
	}

	public void run() {
		try {
			System.out.println("I: waiting for permit");
			semaphore.acquire();
			System.out.println("I: permit acquired");
			for (int i = 0; i < number; i++) {
				counter.increment();
				System.out.println("Cnt: " + counter.getCnt());
				sleep(1000);
			}
			System.out.println("I: releases the permit");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Decrementator extends Thread {
	private Counter counter;
	private int number;
	private Semaphore semaphore;

	public Decrementator(Counter counter, int number, Semaphore sem) {
		this.counter = counter;
		this.number = number;
		this.semaphore = sem;
	}

	public void run() {
		try {
			System.out.println("D: waiting for permit");
			semaphore.acquire();
			System.out.println("D: permit acquired");
			for (int i = 0; i < number; i++) {
				counter.decrement();
				System.out.println("Cnt: " + counter.getCnt());
				sleep(1000);
			}
			System.out.println("D: releases the permit");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Counter {
	private int counter = 0; // 1

	public void increment() {
		counter++;
	}

	public void decrement() {
		counter--;
	}

	public int getCnt() {
		return counter;
	}
}
