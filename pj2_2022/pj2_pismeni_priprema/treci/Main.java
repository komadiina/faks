import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {
	public static void main(String[] args) {
		String putanja = "";

		for (int i = 0; i < args.length; i++)
			if (args[i].equals("--putanja"))
				putanja = args[i+1];

		assert putanja != "";
		System.out.println("Putanja: " + putanja);

		Kategorija racunari = new Kategorija("Racunari", new ArrayList<>());
		Kategorija monitori = new Kategorija("Monitori", new ArrayList<>());
		Kategorija telefoni = new Kategorija("Telefoni", new ArrayList<>());


		Kategorija elektronika = new Kategorija("Elektronika",
			new ArrayList<>(Arrays.asList(racunari, monitori, telefoni))
		);
		
		Proizvod tel1 = new Proizvod("Samsung Galaxy S20", 599.99, telefoni);
		Proizvod tel2 = new Proizvod("iPhone 11 Pro Max", 1999.99, telefoni);
		Proizvod mon1 = new Proizvod("AOC 144Hz", 399.99, monitori);
		Proizvod mon2 = new Proizvod("Dell UltraSharp 24\'\'", 559.99, monitori);
		Proizvod rac1 = new Proizvod("Alienware neki", 4999.99, racunari);
		Proizvod rac2 = new Proizvod("iMac Pro M2", 2999.99, racunari);

		Proizvod konfig1 = new Proizvod("cijela konfiguracija", 8999.99, elektronika);
		Proizvod konfig2 = new Proizvod("ASUS ROG konfiguracija", 2999.99, elektronika);

		List<Proizvod> kolekcija = new ArrayList<>(
			Arrays.asList(
				tel1, tel2, mon1, mon2, rac1, rac2, konfig1, konfig2
			)		
		);

		System.out.println("---- Kolekcija ----");	
		for (Proizvod p : kolekcija)
			System.out.printf("- %1$s%n", p);
		
		List<Proizvod> sortirano = kolekcija.stream()
				.sorted((a, b) -> Integer.compare(
						b.kategorija.potkategorije.size(),
						a.kategorija.potkategorije.size()	
						)
					)
				.collect(Collectors.toList());
	
		System.out.println("---- Sortirano ----");	
		for (Proizvod p : sortirano)
			System.out.printf("- %1$s%n", p);
	}
}