package org.unibl.etf.threads.synchronization4;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
	public static void main(String[] args) throws InterruptedException {
		Exchanger<String> exchanger = new Exchanger<>();		// 1
		new DataThread("A", exchanger, "AAAAAA").start();		// 2
		Thread.sleep(2000);										// 3
		new DataThread("B", exchanger, "BBBBBB").start();		// 4
	}
}

class DataThread extends Thread {								// 1
	String name;
	Exchanger<String> exchanger;
	String data;
	
	public DataThread(String name, Exchanger<String> exchanger, String data) {
		this.name = name;
		this.exchanger = exchanger;
		this.data = data;
	}
		
	public void run() {
		try {
			System.out.println(name + " waiting");
			String received = exchanger.exchange(data);		// 2
			System.out.println(name + " sent " + data);
			System.out.println(name + " received " + received);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

