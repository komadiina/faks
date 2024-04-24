import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;

public class Main {
	@SafeVarargs
	public static <T extends Data> List<T> processData(List<Predicate<T>> predikati, Consumer<T> potrosac, List<T>... liste) {
		List<T> prihvaceni = new ArrayList<>();
		
		for (List<T> lista : liste) {
			for (T objekat : lista) {
				boolean isOk = true;
				
				for (Predicate<T> predikat : predikati)
					isOk = isOk && predikat.test(objekat);
				
				if (isOk)  {
					prihvaceni.add(objekat);
					potrosac.accept(objekat);
				}
			}
		}
		return prihvaceni.stream().sorted((x, y) -> Integer.compare(y.hashCode(), x.hashCode())).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		List<A> a = new ArrayList<>(Arrays.asList(
			new A("TYPE1", 99.9, "RED"),
			new A("TYPE2", 199.9, "GREEN"),
			new A("TYPE1", 5.01, "BLUE")
		));
		
		List<B> b = new ArrayList<>(Arrays.asList(
			new B("TYPE1", 55.1, 0.55),
			new B("TYPE1", 13.49, 0.99),
			new B("TYPE3", 1.122, 0.55)
		));
		
		List<Data> combined1 = new ArrayList<>();
		combined1.addAll(a); combined1.addAll(b);
		
		List<Data> combined2 = new ArrayList<>(a);
		
		Predicate<Data> p1 = x -> x.getType().equals("TYPE1");
		Predicate<Data> p2 = x -> x.getValue() >= 50.0;
		Predicate<Data> p3 = x -> x.getValue() <= 100.0;
		List<Predicate<Data>> plist = new ArrayList<>(Arrays.asList(p1, p2, p3));
		Consumer<Data> dataConsumer = x -> System.out.println(x);
		
		List<Data> result = processData(plist, System.out::println, combined1, combined2);
		
		System.out.println("Sorted: " + result);
	}
}