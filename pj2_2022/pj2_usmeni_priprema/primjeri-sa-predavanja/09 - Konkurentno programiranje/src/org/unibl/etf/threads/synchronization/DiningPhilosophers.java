package org.unibl.etf.threads.synchronization;

public class DiningPhilosophers {
	private static int ITER = 10;
	private static int N = 5;

	public static void main(String[] args) {
		Stick[] sticks = new Stick[N];
		Philosopher[] philos = new Philosopher[N];
		for (int i = 0; i < N; i++) {// 1
			sticks[i] = new Stick();
		}
		for (int i = 0; i < N; i++) {
			philos[i] = new Philosopher(i + 1, sticks[(i - 1 + N) % N], sticks[i], ITER); // 2
			philos[i].start(); // 3
		}
	}
}

class Philosopher extends Thread {
	private int index;
	private Stick left;
	private Stick right;
	private int noOfIterations;

	public Philosopher(int index, Stick left, Stick right, int noOfIterations) {
		this.index = index;
		this.left = left;
		this.right = right;
		this.noOfIterations = noOfIterations;
	}

	public void run() {
		while (noOfIterations > 0) {
			left.take(); // 1
//			try { // 2
//				sleep(100); // 3
//			} catch (Exception e) {
//			} // 4
			right.take(); // 5
			System.out.println("[" + index + "] eating...");
			try {
				sleep(200);
			} catch (Exception ex) {
			}
			left.release();
			right.release();
			noOfIterations--;
		}
		System.out.println("[" + index + "] finished...");

	}
}

class Stick {
	private boolean free;

	public Stick() {
		free = true;
	}

	public synchronized void take() {
		if (!free)
			try {
				wait();
			} catch (Exception ex) {
			}
		free = false;
	}

	public synchronized void release() {
		free = true;
		notify();
	}
}
