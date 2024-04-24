package org.unibl.etf.threads.synchronization3;

import java.util.concurrent.Semaphore;

public class SemDemo {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		new Thread(new IncThread(semaphore, "A")).start();
		new Thread(new DecThread(semaphore, "B")).start();
	}
}

class IncThread implements Runnable{
	private Semaphore semaphore;
	private String name;
	
	public IncThread(Semaphore semaphore, String name) {
		this.semaphore = semaphore;
		this.name = name;
	}
	public void run() {
		System.out.println("Starting " + name);
		try {
			System.out.println(name + " - waiting for permit");
			semaphore.acquire();
			System.out.println(name + " - permit acquired");
			for(int i=0; i<5; i++) {
				Shared.increment();
				System.out.println("Counter: " + Shared.getCounter());
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " - permit released");
		semaphore.release();
	}
}

class DecThread implements Runnable{
	private Semaphore semaphore;
	private String name;
	
	public DecThread(Semaphore semaphore, String name) {
		this.semaphore = semaphore;
		this.name = name;
	}
	public void run() {
		System.out.println("Starting " + name);
		try {
			System.out.println(name + " - waiting for permit");
			semaphore.acquire();
			System.out.println(name + " - permit acquired");
			for(int i=0; i<5; i++) {
				Shared.decrement();
				System.out.println("Counter: " + Shared.getCounter());
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " - permit released");
		semaphore.release();
	}
}

class Shared { 
	private static int counter = 0; 										// 1
	public static void increment() {
		counter++;
	}
	public static void decrement() {
		counter--;
	}
	public static int getCounter() {
		return counter;
	}
}