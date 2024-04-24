package org.unibl.etf.threads.synchronization5;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Incrementator extends Thread {
	private Counter counter;
	private int number;
	public Incrementator(Counter counter, int number) {
		this.counter = counter;
		this.number = number;
	}
	public void run() {
		for (int i = 0; i < number; i++){
			counter.increment1();								// 1
			counter.increment2();								// 2
		}
	}
	public static void main(String args[]){
		Counter cnt = new Counter();							// 3
		Incrementator inc1 = new Incrementator(cnt, 5);	// 4
		Incrementator inc2 = new Incrementator(cnt, 5);	// 5
		inc1.start(); inc2.start();
	}
}


//class Counter { 
//	private long c1 = 0; 										// 1
//	private long c2 = 0; 										// 2
//
//	public void increment1() { 								// 3
//		long tmp = c1;											// 4
//		c1++;														// 5
//		System.out.println("Inc c1: " + tmp + " -> " + c1);
//	} 
//	public void increment2() { 								// 6
//		long tmp = c2;
//		c2++;
//		System.out.println("Inc c2: " + tmp + " -> " + c2);
//	} 
//}


//class Counter { 
//	private long c1 = 0; 										// 1
//	private long c2 = 0; 										// 2
//	private Object lock1 = new Object(); 
//	private Object lock2 = new Object(); 
//
//	public void increment1() { 								// 3
//		synchronized(lock1) { 
//			long tmp = c1;											// 4
//			c1++;														// 5
//			System.out.println("Inc c1: " + tmp + " -> " + c1);
//		}
//	} 
//	public void increment2() { 								// 6
//		synchronized(lock2) { 
//			long tmp = c2;
//			c2++;
//			System.out.println("Inc c2: " + tmp + " -> " + c2);
//		}
//	} 
//}

//class Counter { 
//	private long c1 = 0; 
//	private long c2 = 0; 
//	private Lock lock1 = new ReentrantLock();
//	private Lock lock2 = new ReentrantLock();
//	public void increment1() {
//		lock1.lock();
//		try {
//			long tmp = c1;
//			c1++;
//			System.out.println("Inc c1: " + tmp + " -> " + c1);
//		} finally {
//			lock1.unlock();
//		}
//	}
//	public void increment2() {
//		lock2.lock();
//		try {
//			long tmp = c2;
//			c2++;
//			System.out.println("Inc c2: " + tmp + " -> " + c2);
//		} finally {
//			lock2.unlock();
//		}
//	}
//}


class Counter { 
	private AtomicLong c1 = new AtomicLong(0); 
	private AtomicLong c2 = new AtomicLong(0); 
	public void increment1() {
		System.out.println("Inc c1: " + c1.incrementAndGet());
	} 
	public void increment2() {
		System.out.println("Inc c2: " + c2.incrementAndGet());
	}
}


