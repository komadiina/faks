import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;

public class Student implements Serializable {
	public String ime, prezime;
	public Integer indeks;
	public HashSet<Integer> predmeti = new HashSet<>();
	
	public Student(String ime, String prezime, Integer indeks, HashSet<Integer> predmeti) {
		this.ime = ime; this.prezime = prezime;
		this.indeks = indeks;
		this.predmeti = predmeti;
	}
	
	public void dodajPredmet(Integer identifikator) {
		predmeti.add(identifikator);
	}
	
	public void dodajPredmet(Predmet p) {
		predmeti.add(p.id);
	}
	
	public static Student fromString(String str) {
		String[] tokens = str.split(" ");
	
		String ime = tokens[0], prezime = tokens[1];
		Integer indeks = Integer.parseInt(tokens[2]);
		HashSet<Integer> predmeti = new HashSet<>();
		
		for (int i = 3; i < tokens.length; i++)
			predmeti.add(Integer.parseInt(tokens[i]));
		
		return new Student(ime, prezime, indeks, predmeti);
	}
}