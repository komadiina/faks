package net.etfbl.concurrency;


public class FirstDaemonThread extends Thread {
	static boolean first = true;
	public FirstDaemonThread(String name){
		setName(name);
		setDaemon(true);
		if(first){
			first = false;
			new T("AAA").start();
		}
	}
	public void run(){
		System.out.println("Start niti " + getName());
		for(int i=0; i<1_000_000; i++) {
			if(i%1000==0) {
				System.out.println("nit " + getName() + ": " + i/1000);
			}
		}
		System.out.println("Kraj niti " + getName());
	}
	
	public static void main(String[] args) {
		System.out.println("Pocetak programa");
		FirstDaemonThread thread1 = new FirstDaemonThread("1");
		thread1.start();
		FirstDaemonThread thread2 = new FirstDaemonThread("2");
		thread2.start();
		FirstDaemonThread thread3 = new FirstDaemonThread("3");
		thread3.start();
		System.out.println("Kraj programa");
	}
}

class T extends Thread{
	
	public T(String name) {
		setName(name);
	}
	@Override
	public void run() {
		System.out.println("Start niti " + getName());
		for(int i=0; i<100_000; i++)
			if(i%1000==0) {
				System.out.println("nit " + getName() + ": " + i/1000);
			}
		System.out.println("Kraj niti " + getName());
	}
}
