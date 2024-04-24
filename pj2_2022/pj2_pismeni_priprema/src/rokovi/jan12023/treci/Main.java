package rokovi.jan12023.treci;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        // electronics, literature, fashion, accessories, beauty | EUR, USD
        productList.add(new Product("1", "Laptop", "Electronics", 1500.0, "EUR", 10));
        productList.add(new Product("2", "Smartphone", "Electronics", 1000.0, "USD", 15));
        productList.add(new Product("3", "Book", "Literature", 20.0, "USD", 50));
        productList.add(new Product("4", "Shoes", "Fashion", 80.0, "USD", 25));
        productList.add(new Product("5", "Headphones", "Electronics", 150.0, "USD", 20));
        productList.add(new Product("6", "T-shirt", "Fashion", 30.0, "EUR", 40));
        productList.add(new Product("7", "Watch", "Accessories", 200.0, "USD", 52));
        productList.add(new Product("8", "Sunglasses", "Accessories", 50.0, "EUR", 30));
        productList.add(new Product("9", "Camera", "Electronics", 800.0, "EUR", 5));
        productList.add(new Product("10", "Gaming Console", "Electronics", 400.0, "USD", 8));
        productList.add(new Product("11", "Dress", "Fashion", 100.0, "EUR", 15));
        productList.add(new Product("12", "Backpack", "Accessories", 70.0, "USD", 20));
        productList.add(new Product("13", "Speaker", "Electronics", 120.0, "EUR", 66));
        productList.add(new Product("14", "Jeans", "Fashion", 60.0, "USD", 140));
        productList.add(new Product("15", "Perfume", "Beauty", 50.0, "USD", 40));

        // a)
        productList.stream()
                .collect(Collectors.groupingBy(x -> x.productCategory))
                .values().forEach(y -> System.out.printf("Kolicina: %1$d%n", y.size()));

        // b)
        productList.stream()
                .filter(x -> x.quantity >= 50 && x.quantity <= 70)
                .forEach(x -> System.out.printf("Proizvod: %1$s, kolicina: %2$d%n", x.productName, x.quantity));

        // c)
        // najniza
        System.out.println("najniza");
        productList.stream()
                .collect(Collectors.groupingBy(x -> x.productCategory))
                .values().forEach(
                        list -> {
                            System.out.println(list.stream().min(Comparator.comparingDouble(y -> y.price)));
                        }
                );

        // najvisa
        System.out.println("najvisa");
        productList.stream()
                .collect(Collectors.groupingBy(x -> x.productCategory))
                .values().forEach(
                        list -> {
                            System.out.println(list.stream().max(Comparator.comparingDouble(y -> y.price)));
                        }
                );

        productList.stream().sorted(Comparator.comparing(x -> x.currency))
                .forEachOrdered(y -> System.out.println(y.currency));

        productList.stream().filter(y -> y.currency.equals("EUR"))
                .peek(y -> {y.price *= 1.95; y.currency = "BAM";})
                .sorted(Comparator.comparing(y -> y.productName))
                .forEachOrdered(System.out::println);
    }
}
