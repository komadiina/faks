package net.etfbl.lambdas.examples;

public class MessageRepeater {
	
	public static void main(String[] args) {
		String content = "text";
		int count = 100;
		repeatMessage(content, count);
	}
	
	public static void repeatMessage(String content, int count) {
		Runnable r = () -> {
			for (int i = 1; i <= count; i++) {
				System.out.println(content + " " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(r).start();
	}
}
