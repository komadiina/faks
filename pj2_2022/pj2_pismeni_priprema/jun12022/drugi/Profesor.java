import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;

public class Profesor implements Serializable {
	public String ime, prezime;
	public Integer jmbg;
	public HashSet<Integer> predmeti = new HashSet<>();
	
	public Profesor(String ime, String prezime, Integer jmbg, HashSet<Integer> predmeti) {
		this.ime = ime; this.prezime = prezime;
		this.jmbg = jmbg;
		this.predmeti = predmeti;
	}
	
	public void dodajPredmet(Integer identifikator) {
		predmeti.add(identifikator);
	}
	
	public void dodajPredmet(Predmet p) {
		predmeti.add(p.id);
	}
	
	public static Profesor fromString(String str) {
		String[] tokens = str.split(" ");
	
		String ime = tokens[0], prezime = tokens[1];
		Integer jmbg = Integer.parseInt(tokens[2]);
		HashSet<Integer> predmeti = new HashSet<>();
		
		for (int i = 3; i < tokens.length; i++)
			predmeti.add(Integer.parseInt(tokens[i]));
		
		return new Profesor(ime, prezime, jmbg, predmeti);
	}
}