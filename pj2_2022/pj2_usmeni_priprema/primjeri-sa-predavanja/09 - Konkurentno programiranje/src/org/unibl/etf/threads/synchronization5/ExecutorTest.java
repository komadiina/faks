package org.unibl.etf.threads.synchronization5;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

	// public static void main(String[] args) {
	// Executor e = Executors.newCachedThreadPool(); // 1
	// Runnable thread = new MyThread("1");
	// e.execute(thread);
	// Runnable thread2 = new MyThread("2");
	// e.execute(thread2);
	// Runnable thread3 = new MyThread("3");
	// e.execute(thread3);
	// }

	// public static void main(String[] args) {
	// ScheduledExecutorService e = Executors.newScheduledThreadPool(3);
	// Runnable thread = new MyThread("1"); // 1
	// e.schedule(thread, 5, TimeUnit.SECONDS); // 2
	// Runnable thread2 = new MyThread("2"); // 3
	// e.schedule(thread2, 1, TimeUnit.SECONDS); // 4
	// Runnable thread3 = new MyThread("3"); // 5
	// e.schedule(thread3, 1, TimeUnit.SECONDS); // 6
	// e.shutdown();
	// }

	public static void main(String[] args) {
		ExecutorService e = Executors.newSingleThreadExecutor();
		Runnable thread = new MyThread("1");
		e.execute(thread);
		Runnable thread2 = new MyThread("2");
		e.execute(thread2);
		e.shutdown();

		Runnable runnable = new MyThread("1");
		ExecutorService executor = Executors.newSingleThreadExecutor();
		(new Thread(runnable)).start();								// 1
		executor.execute(runnable);									// 2

	}

}

class MyThread implements Runnable { // 7
	String name = "";

	public MyThread(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println("Thread " + name + " start");
		for (int i = 0; i < 50; i++) {
			System.out.println("Thread " + name + ": " + i);
		}
		System.out.println("Thread " + name + " end");
	}
}
