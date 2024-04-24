package net.etfbl.streams;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {

	public static void main(String[] args) {
		Stream<String> streamOf = Stream.of("value");
		Stream<String> streamOf2 = Stream.of("value 1", "value 2");
		Stream<String> streamEmpty = Stream.empty();
		Stream<String> streamGenerate = Stream.generate(() -> "element");
		Stream<Double> streamGenerate2 = Stream.generate(Math::random);
		Stream<BigInteger> streamIterate = Stream.iterate(BigInteger.ZERO, n -> n.intValue() < 100,
				n -> n.add(BigInteger.ONE));
		streamIterate.forEach(System.out::println);
		
		Stream<BigInteger> streamIterate2 = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
		streamIterate2.forEach(System.out::println);
		
		Stream<String> streamOfNullable = Stream.ofNullable(null);
		streamOfNullable.forEach(System.out::println);
		
		Stream.Builder<String> sb = Stream.builder();
		Stream<String> streamBuilder = sb.add("a").add("b").add("c").build();
		streamBuilder.forEach(System.out::println);
		
		Long count =Stream.ofNullable(100).count();
		System.out.println(count);
		Long countNull =Stream.ofNullable(null).count();
		System.out.println("Count null "+countNull);
		
		String s = "abc";
		IntStream intStream = s.chars();
		intStream.forEach(System.out::println);
	}

}
