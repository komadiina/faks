package org.unibl.etf.threads.synchronization;

public class SynchronizationTest {
	public static void main(String[] args) {				// 1
		MessagePrinter mp = new MessagePrinter();			// 2
		Consumer consumer1 = new Consumer(mp, "Java");		// 3
		Consumer consumer2 = new Consumer(mp, "Hello");		// 4
		Consumer consumer3 = new Consumer(mp, "Message");		// 5
		consumer1.start();										// 6
		consumer2.start();										// 7
		consumer3.start();										// 8
	}
}

class Consumer extends Thread {								// 9
	private MessagePrinter mp;									// 10
	private String message;										// 11
	public Consumer(MessagePrinter mp, String message) {	// 12
		this.mp = mp;
		this.message = message;
	}
	public void run() {
		mp.printReverse(message);							// 13
	}
}

class MessagePrinter {											// 14
	public synchronized void printReverse(String msg) {	// 15
		for (int i = msg.length() - 1; i >= 0; i--) {
			System.out.print(msg.charAt(i));
		}
		System.out.println();
	}
}

