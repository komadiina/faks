package org.unibl.etf.lambdas;

public class TestThread3 {

	public static void main(String[] args) throws InterruptedException {
		Runnable r = new Thread3();
		Runnable r2 = () -> {
			Thread.sleep(1);
			for (int i = 0; i < 10000; i++)
				;
		};
	}

}
