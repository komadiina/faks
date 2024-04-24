package org.unibl.etf.lambdas;

import java.util.stream.Stream;

public class TestMain {

	public static void main(String[] args) {

//		System.out::println 		<=> 	x -> System.out.println(x)
//		Math::pow 					<=>		(x, y) -> Math.pow(x, y)
//		String::compareToIgnoreCase <=> 	(x, y) -> x.compareToIgnoreCase(y)
		Stream<Integer> stream = Stream.of(1,2,3,4);
		int i = stream.max(Integer::compare).get();
		System.out.println(i);
	}

}
