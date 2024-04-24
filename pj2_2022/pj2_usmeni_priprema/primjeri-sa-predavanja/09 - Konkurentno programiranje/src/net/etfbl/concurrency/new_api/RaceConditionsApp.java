package net.etfbl.concurrency.new_api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceConditionsApp implements Runnable {
	private final static int LOOP_LIMIT = 5;
	private final static int POOL_SIZE = 10;
	private int latestThreadNum = 0;

	public RaceConditionsApp() throws InterruptedException {
		ExecutorService taskList;
		taskList = Executors.newFixedThreadPool(POOL_SIZE);
		for (int i = 0; i < POOL_SIZE; i++) {
			taskList.execute(this);
		}
		taskList.shutdown();
		taskList.awaitTermination(10, TimeUnit.SECONDS);
	}

	public void run() {
		int currentThreadNum = latestThreadNum;
		System.out.println("Set currentThreadNum to " + currentThreadNum);
		latestThreadNum = latestThreadNum + 1;
		for (int i = 0; i < LOOP_LIMIT; i++) {
			method(currentThreadNum);
		}
	}

	private void method(int threadNumber) {
//		System.out.println("method: " + threadNumber);
	}
	
	public static void main(String[] args) throws InterruptedException {
		new RaceConditionsApp();
	}
}