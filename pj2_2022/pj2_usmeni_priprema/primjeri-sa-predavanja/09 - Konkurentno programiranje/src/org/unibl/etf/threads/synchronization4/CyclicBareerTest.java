package org.unibl.etf.threads.synchronization4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBareerTest {
	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier cb = new CyclicBarrier(2);
		new ConsolePrinterThread(cb, "A").start();
		Thread.sleep(2000);
		new ConsolePrinterThread(cb, "B").start();
		Thread.sleep(2000);
		new ConsolePrinterThread(cb, "C").start();
		Thread.sleep(2000);
		new ConsolePrinterThread(cb, "D").start();
	}
}

class ConsolePrinterThread extends Thread {
	private String name;
	private CyclicBarrier cyclicBarrier;
	public ConsolePrinterThread(CyclicBarrier cb, String n) {
		cyclicBarrier = cb;
		name = n;
	}
	public void run() {
		System.out.println(name + ": bareer reached");
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(name + ": end");
	}
}
