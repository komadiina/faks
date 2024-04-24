import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;


public class Main {
	public static List<Song> getSongs(String filename) {
		List<String> content = new ArrayList<>();
		List<Song> songs = new ArrayList<>();
		
		try {
			content = Files.readAllLines(Paths.get(filename));
		} catch (Exception ex) { ex.printStackTrace(); }
		
		for (String line : content)
			songs.add(Song.fromString(line));
		
		return songs;
	}
	
	public static void main(String[] args) {
		String path = "";
		
		for (int i = 0; i < args.length; i++)
			if (args[i].equals("--putanja"))
				path = args[i+1];
		
		assert path != "";
		path = System.getProperty("user.dir") + File.separator + path;
		
		List<Song> songs = getSongs(path);
		// songs.forEach(System.out::println);
		
		System.out.println("------- PO GODINI -------");
		List<Song> poGodini = songs.stream()
				.collect(Collectors.groupingBy(p -> p.godina))
				.values().stream()
				.flatMap(List::stream)
				.sorted((x, y) -> Integer.compare(y.godina, x.godina))
				.collect(Collectors.toList());
		
		poGodini.forEach(System.out::println);
		
		System.out.println("------- PO IZVODJACU -------");
		List<Song> poIzvodjacu = songs.stream()
				.collect(Collectors.groupingBy(p -> p.izvodjac))
				.values().stream()
				.flatMap(List::stream)
				.collect(Collectors.toList());
		
		poIzvodjacu.forEach(System.out::println);
	
		System.out.println("------- DUZE OD 3 MINUTE -------");
		List<Song> duzinaVecaOd3Min = songs.stream()
				.filter(p -> p.trajanje >= 180)
				.collect(Collectors.toList());
		
		duzinaVecaOd3Min.forEach(System.out::println);
		
		System.out.println("------- 2010 -:- 2019 -------");
		List<Song> drugaDecenija = songs.stream()
				.filter(p -> p.godina >= 2010 && p.godina <= 2019)
				.collect(Collectors.toList());
				
		drugaDecenija.forEach(System.out::println);
		
		System.out.println("------- PROSJECNA DUZINA PJESAMA 80-IH -------");
		Double osamdesete = songs.stream()
				.filter(p -> p.godina >= 1980 && p.godina < 1990)
				.mapToInt(p -> p.trajanje)
				.average().orElse(0.0);
		System.out.println(osamdesete);
	}
}