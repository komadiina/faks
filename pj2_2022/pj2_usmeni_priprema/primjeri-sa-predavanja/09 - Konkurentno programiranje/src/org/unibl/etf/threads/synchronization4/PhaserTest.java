package org.unibl.etf.threads.synchronization4;

import java.util.concurrent.Phaser;

public class PhaserTest {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(1);						// 1
		int currentPhase = 0;
		new ProcessorThread("A", phaser).start();			// 2
		new ProcessorThread("B", phaser).start();			// 3
		new ProcessorThread("C", phaser).start();			// 4
		currentPhase = phaser.getPhase();						
		phaser.arriveAndAwaitAdvance();						// 5
		System.out.println("Completed phase " + currentPhase);
		currentPhase = phaser.getPhase();						
		phaser.arriveAndAwaitAdvance();						// 6
		System.out.println("Completed phase " + currentPhase);
		currentPhase = phaser.getPhase();						
		phaser.arriveAndAwaitAdvance();						// 7
		System.out.println("Completed phase " + currentPhase);
		phaser.arriveAndDeregister();							// 8
		System.out.println("All phases completed");
	}
}


class ProcessorThread extends Thread {
	private String name;
	private Phaser phaser;
	
	public ProcessorThread(String name, Phaser phaser) {
		this.name = name;
		this.phaser = phaser;
		phaser.register();
	}

	public void run() {
		System.out.println(name + " beginning phase 0");
		phaser.arriveAndAwaitAdvance();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " beginning phase 1");
		phaser.arriveAndAwaitAdvance();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " beginning phase 2");
		phaser.arriveAndDeregister();
	}
}