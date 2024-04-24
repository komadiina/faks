package net.etfbl.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CoresTest {

	public static void main(String[] args) throws InterruptedException {
		long time1 = testThread();
		long time2 = testThreads();
		System.out.println("Single thread exec time: " + time1);
		System.out.println("Multiple threads exec time: " + time2);
	}

	private static long testThreads() throws InterruptedException {
		long start = System.currentTimeMillis();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new CoreThread());
		}
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.HOURS);
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static long testThread() {
		long start = System.currentTimeMillis();

		for (int i = 0; i < 10; i++) {
			int maxCheck = 200_000;
			boolean isPrime = true;
			for (int j = 1; j <= maxCheck; j++) {
				isPrime = checkPrime(j);
				if (isPrime) {
					System.out.println(j);
				}
			}
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static boolean checkPrime(int numberToCheck) {
		int remainder;
		for (int i = 2; i <= numberToCheck / 2; i++) {
			remainder = numberToCheck % i;
			if (remainder == 0) {
				return false;
			}
		}
		return true;

	}

}