package net.etfbl.lambdas.examples;

public class MessageRepeater3 {

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
			System.out.println(this.toString());
		};
		new Thread(r).start();
	}

	@Override
	public String toString() {
		return "MessageRepeater object";
	}
}