package net.etfbl.lambdas.examples;

public class MessageRepeater2 {
//	static int count = 10;
	
	public static void main(String[] args) {
		String content = "text";
		for(int i=0; i<10; i++){
			repeatMessage(i + "->" +  content);
		}
	}
	
	public static void repeatMessage(String content) {
		int count = 10;
		Runnable r = () -> {
//			int count = 1;
			for (int i = 1; i <= count; i++) {
				System.out.println(content + " " + i);
			}
		};
		new Thread(r).start();
	}
}
