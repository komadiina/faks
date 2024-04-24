package net.etfbl.streams;

import java.util.Arrays;
import java.util.Optional;

public class StreamExamples2 {
	public static void main(String[] args) {
		Optional<Integer> reduced = Arrays.asList(1, 2, 3).stream().reduce((a, b) -> a + b);
		System.out.println("R1: " + reduced.get());
		int reduced2 = Arrays.asList(1, 2, 3).stream().reduce(1, (a, b) -> a + b);
		System.out.println("R2: " + reduced2);
		int reduced3 = Arrays.asList(1, 2, 3, 4).stream().reduce(1, (a, b) -> a + b, (a, b) -> {
			System.out.println("combiner");
			return a + b;
		});
		System.out.println("R3: " + reduced3);
		int reduced4 = Arrays.asList(1, 2, 3).parallelStream().reduce(1, (a, b) -> a + b, (a, b) -> {
			System.out.println("combiner");
			return a + b;
		});
		System.out.println("R4: " + reduced4);
	}
}
