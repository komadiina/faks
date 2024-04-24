package org.unibl.etf.threads;

public class ThreadStates {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		while (true) {				    				// 1
		     Thread.State state = myThread.getState();	// 2
		     System.out.println(state);
		     if (state == Thread.State.TERMINATED)
			    break;
		}
	}
}
class MyThread extends Thread{
	public void run() {					  				// 3
		try {
			sleep(1);				  					// 4
			for (int i =0; i < 10000; i++)	  			// 5
				;
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
