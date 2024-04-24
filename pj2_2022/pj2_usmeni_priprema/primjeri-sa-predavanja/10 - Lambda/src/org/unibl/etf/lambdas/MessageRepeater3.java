package org.unibl.etf.lambdas;

public class MessageRepeater3 {
	int instanceVariable = 1;
	static int staticVariable = 1;
	
	public static void main(String[] args) {
		MessageRepeater3 mr = new MessageRepeater3();
		mr.repeatMessage("test");
	}

	public void repeatMessage(String content) {
		int count = 10;
		Runnable r = () -> {
			for (int i = 1; i <= count; i++) {
				System.out.println(content + " " + i);
			}
			System.out.println("instanceVariable: " + ++instanceVariable);
			System.out.println("staticVariable: " + ++staticVariable);
			System.out.println(this.toString());
		};
		new Thread(r).start();
	}

	@Override
	public String toString() {
		return "MessageRepeater object";
	}
}