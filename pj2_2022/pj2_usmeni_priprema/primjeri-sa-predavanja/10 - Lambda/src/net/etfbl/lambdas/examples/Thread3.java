package net.etfbl.lambdas.examples;

class Thread3 extends Thread{
	public void run() {					  // 3
		try {
			sleep(1);				  // 4
			for (int i =0; i < 10000; i++)	  // 5
				;
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
