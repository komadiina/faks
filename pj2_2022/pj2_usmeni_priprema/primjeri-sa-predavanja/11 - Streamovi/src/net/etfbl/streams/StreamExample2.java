package net.etfbl.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample2 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 10, 20, 50, 100, 250, 200, 500, 300, 200);
		Optional<Integer> result = numbers.stream().distinct().filter(e -> e > 100).reduce((a, b) -> a + b);
		System.out.println(result.get());
		numbers.stream().distinct().sorted().forEach(System.out::println);

		System.out.println("================");
		numbers.stream().distinct().sorted((a, b) -> b - a).forEach(System.out::println);
		
		System.out.println("================");
		numbers.parallelStream().distinct().sorted((a, b) -> b - a).forEachOrdered(System.out::println);

		System.out.println("================");
		Stream.iterate(2, e -> e + 2).peek(e -> {
			System.out.println("iterate");
		}).limit(5).forEach(System.out::println);
	}

}
