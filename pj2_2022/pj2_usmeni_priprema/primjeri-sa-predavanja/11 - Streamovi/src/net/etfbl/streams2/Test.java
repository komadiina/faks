package net.etfbl.streams2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Abc", "Defg", "hjklm", "nopqwerty");
		Stream<String> stream = list.stream();
//		stream.forEach(e -> System.out.println(e));
//		System.out.println("=======================");
//		stream = list.stream();
//		stream.filter(e -> e.length() > 3).forEach(e -> System.out.println(e));
//		System.out.println("=======================");
//		stream = list.stream();
//		stream.map(e -> e + e).forEach(e -> System.out.println(e));
//
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		Stream<Integer> intStream = intList.stream();
//		 intStream.map(e->e*e).map(e->Math.sqrt(e)).forEach(e->System.out.println(e));
//		intStream.filter(e -> e > 3).forEach(System.out::println);

//		Optional<Integer> optiInt = intStream.filter(e -> e > 8).findFirst();
//		if(optiInt.isPresent()){
//			System.out.println(optiInt.get());
//		}else{
//			System.out.println("aaa");
//		}
		
		Integer optiInt = intStream.filter(e -> e > 3).findFirst().orElse(0);
		System.out.println(optiInt);
	}

}
