package org.unibl.etf.threads.synchronization3;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(5); // 1
		new ConsolePrinterThread(cdl).start(); // 2
		try {
			cdl.await(); // 3
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done"); // 4
	}
}

class ConsolePrinterThread extends Thread { // 5
	private CountDownLatch countDownLatch;
	public ConsolePrinterThread(CountDownLatch cdl) {
		countDownLatch = cdl;
	}
	public void run() {
		for (int i = 0; i < 5; i++) {			// 6
			System.out.println("Print: " + i); // 7
			countDownLatch.countDown(); // 8
			try {
				Thread.sleep(1000); // 9
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
