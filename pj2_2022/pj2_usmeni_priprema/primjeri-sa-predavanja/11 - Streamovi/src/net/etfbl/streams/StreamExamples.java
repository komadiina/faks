package net.etfbl.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamExamples {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("ab", "bc", "cd").filter(element -> element.contains("c"));
		Optional<String> firstElement = stream.findFirst();
		// Optional<String> anyElement = stream.findAny();
		System.out.println(firstElement.get());
		System.out.println("===");

		List<String> list = Arrays.asList("abcdef", "bcdefg", "cdefgh");
		long size = list.stream().skip(1).map(element -> element.substring(0, 3)).peek(e -> {
			System.out.println("map()");
		}).sorted().count();
//		long size = list.stream().map(element -> element.substring(0, 3)).peek(e -> {
//			System.out.println("map()");
//		}).skip(1).sorted().count();
		System.out.println(size);
		System.out.println("===");

		Optional<String> firstElement2 = list.stream().filter(element -> {
			System.out.println("filter()");
			return element.contains("g");
		}).map(element -> {
			System.out.println("map()");
			return element.toUpperCase();
		}).findFirst();
		System.out.println(firstElement2.get());
		System.out.println("===");

	}
}
