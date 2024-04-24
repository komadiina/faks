package net.etfbl.concurrency;

public class ThreadStates {

	public static void main(String[] args) {
		MyThread5 thread = new MyThread5();
		thread.start();
		while (true) {
			Thread.State state = thread.getState();
			System.out.println(state);
			if (state == Thread.State.TERMINATED)
				break;
		}
	}
}

class MyThread5 extends Thread{
	public void run() {
		try {
			sleep(10);
			for (int i =0; i < 100000; i++)
				;
			Thread t = new MyThread6();
			t.start();
			t.join();
			for (int i =0; i < 100000; i++)
				;
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}

class MyThread6 extends Thread{
	public void run() {
		for (int i =0; i < 100000; i++)
			//System.out.println(i);
			;
	}
}