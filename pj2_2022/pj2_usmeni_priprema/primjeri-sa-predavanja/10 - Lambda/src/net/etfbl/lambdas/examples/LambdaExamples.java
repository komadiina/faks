package net.etfbl.lambdas.examples;

import java.util.function.Supplier;

import javax.swing.JButton;

public class LambdaExamples {
	private static JButton jButton = new JButton("Lambda");

	public static void main(String[] args) {
		jButton.addActionListener(e -> {
			System.out.println("Button clicked...");
		});

		Cube cube = produce(() -> new Cube());
	}

	public static Cube produce(Supplier<Cube> supplier) {
		return supplier.get();
	}
}

class Cube {
	public Cube() {
		System.out.println("Cube constructor...");
	}
}
