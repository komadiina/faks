package org.unibl.etf.threads.synchronization2;

public class DiningPhilosophers {
	private static int ITER = 10;
	private static int N = 5;

	public static void main(String[] args) {
		Stick[] sticks = new Stick[N];
		Philosopher[] philos = new Philosopher[N];
		for (int i = 0; i < N; i++) {
			sticks[i] = new Stick(); // 1
		}
		for (int i = 0; i < N; i++) {
			philos[i] = new Philosopher(i + 1, sticks[(i - 1 + N) % N], sticks[i], (i + 1) % 2 == 1 ? "L" : "R", ITER); // 2
			philos[i].start(); // 3
		}
	}
}

class Philosopher extends Thread {
	private int index;
	private Stick first;
	private Stick second;
	private int noOfIterations;

	public Philosopher(int index, Stick left, Stick right, String type, int noOfIterations) {
		this.index = index;
		if (type.equals("L")) {
			this.first = left; // 1
			this.second = right; // 2
		} else {
			this.first = right; // 3
			this.second = left; // 4
		}
		this.noOfIterations = noOfIterations;
	}

	public void run() {
		while (noOfIterations > 0) {
			first.take();
			try {
				sleep(1000); // 5
			} catch (Exception e) {
			}
			second.take();
			System.out.println("[" + index + "] eating...");
			try {
				sleep(200);
			} catch (Exception ex) {
			}
			first.release();
			second.release();
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
