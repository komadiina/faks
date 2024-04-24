package net.etfbl.streams;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExamples3 {
	public static void main(String[] args) throws IOException {
		List<Product> products = Arrays.asList(new Product("Shoes A.java", "Running Shoes", 20),
				new Product("Shoes B", "Running Shoes", 55), new Product("Shoes C", "Soccer", 30),
				new Product("Shoes D", "Soccer", 20), new Product("Shoes E", "Hiking", 55),
				new Product("Shoes F", "Hiking", 30));
		List<String> productsList = products.stream().map(Product::getName).collect(Collectors.toList());
		productsList.stream().forEach(System.out::println);
		System.in.read();
		String productsString = products.stream().map(Product::getName).collect(Collectors.joining(",", "[", "]"));
		Set<Product> productsSet = products.stream().collect(Collectors.toSet());
		// productsSet.forEach(System.out::println);
		Map<String, Product> productsMap = products.stream()
				.collect(Collectors.toMap(Product::getName, Function.identity()));
		// productsMap.forEach((x, y) -> {
		// System.out.print("Key: " + x);
		// System.out.println(" - Value: " + y);
		// });
		IntSummaryStatistics statistics = products.stream().collect(Collectors.summarizingInt(Product::getPrice));
		 System.out.println(statistics);
		Map<String, List<Product>> productsGrouped = products.stream()
				.collect(Collectors.groupingBy(Product::getCategory));
		// collectorMapOfLists.forEach((x, y) -> {
		// System.out.println(x + " -> " + y);
		// });
		Map<Boolean, List<Product>> productsPartitioned = products.stream()
				.collect(Collectors.partitioningBy(e -> e.getPrice() > 30));
		// productsPartitioned.forEach((x, y) -> {
		// System.out.println(x + " -> " + y);
		// });

		Set<Product> unmodifiableSet = products.stream()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
	}
}

class Product {
	private String name;
	private String category;
	private int price;
	public Product(String name, String category, int price) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public int getPrice() {
		return price;
	}
}
