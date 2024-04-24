package org.unibl.etf.threads.synchronization;

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


class Counter { 
	private long c1 = 0; 										// 1
	private long c2 = 0; 										// 2
	private Object lock1 = new Object(); 
	private Object lock2 = new Object(); 

	public void increment1() { 								// 3
		synchronized(lock1) { 
			long tmp = c1;											// 4
			c1++;														// 5
			System.out.println("Inc c1: " + tmp + " -> " + c1);
		}
	} 
	public void increment2() { 								// 6
		synchronized(lock2) { 
			long tmp = c2;
			c2++;
			System.out.println("Inc c2: " + tmp + " -> " + c2);
		}
	} 
}

