package net.etfbl.concurrency;

public class CoreThread extends Thread {
	@Override
	public void run() {
		int maxCheck = 200_000;
		boolean isPrime = true;
		for (int j = 1; j <= maxCheck; j++) {
			isPrime = checkPrime(j);
			if (isPrime) {
				System.out.println(j);
			}
		}
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
