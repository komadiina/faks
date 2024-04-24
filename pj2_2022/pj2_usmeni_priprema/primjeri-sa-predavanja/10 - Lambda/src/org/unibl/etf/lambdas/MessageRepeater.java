package org.unibl.etf.lambdas;

public class MessageRepeater {
	
	public static void main(String[] args) {
		String content = "text";
		int count = 100;
		repeatMessage(content, count);						// 1
	}
	
	public static void repeatMessage(String ct, int c) {	// 2
		Runnable r = () -> {
			for (int i = 1; i <= c; i++) {					// 3
				System.out.println(ct + " " + i);				// 4
			}
		};
		new Thread(r).start();
	}
}

