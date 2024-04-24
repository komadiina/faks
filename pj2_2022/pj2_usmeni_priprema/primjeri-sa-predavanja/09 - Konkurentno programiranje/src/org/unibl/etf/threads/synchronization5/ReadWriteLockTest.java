package org.unibl.etf.threads.synchronization5;

import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
	public final static int READER_THREADS = 4; // 1
	public final static int NUM = 5; // 2

	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		Container container = new Container(); // 3
		ContainerRW rwt = new ContainerRW(container, NUM, "W"); // 4
		e.execute(rwt);
		for (int i = 0; i < READER_THREADS; i++) {
			e.execute(new ContainerRW(container, NUM, "R")); // 5
		}
		e.shutdown();
	}
}

class Container {
	private Vector<String> container = new Vector<String>();
	private ReentrantReadWriteLock l = new ReentrantReadWriteLock();

	public void writeData(String str) { // 1
		l.writeLock().lock();
		print("W: threads wait: " + l.getQueueLength()); // 2
		print("W: write locks: " + l.getWriteHoldCount()); // 3
		container.add(str);
		print("W: " + str);
		try {
			Thread.sleep(1000); // 4
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		l.writeLock().unlock();
	}

	public void readData() { // 5
		l.readLock().lock();
		print("R: threads wait: " + l.getQueueLength()); // 6
		print("R: read locks: " + l.getReadLockCount()); // 7
		Iterator<String> iter = container.iterator();
		while (iter.hasNext()) {
			System.out.println("R: " + iter.next());
		}
		try {
			Thread.sleep(1000); // 8
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		l.readLock().unlock();
	}
	
	private void print(String s) {
		System.out.println(s);
	}
}

class ContainerRW implements Runnable { // 1
	private Container container;
	private int number;
	private String type;

	public ContainerRW(Container c, int n, String t) {
		container = c;
		number = n;
		type = t; // 2
	}

	public void run() {
		if (type.equals("W"))
			for (int i = 0; i < number; i++) {
				container.writeData("[" + i + "]"); // 3
			}
		else
			for (int i = 0; i < number; i++) {
				container.readData(); // 4
			}
	}
}
