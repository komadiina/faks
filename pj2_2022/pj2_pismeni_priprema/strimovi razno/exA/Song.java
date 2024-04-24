import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;

public class Song {
	public String izvodjac;
	public Integer godina;
	public Integer trajanje;
	
	public Song(String izvodjac, Integer godina, Integer trajanje) {
		this.izvodjac = izvodjac;
		this.godina = godina;
		this.trajanje = trajanje;
	}
	
	@Override
	public String toString() {
		return String.format("Izvodjac: %1$s | Godina: %2$d | Trajanje [s]: %3$d", izvodjac, godina, trajanje);
	}
	
	public static Song fromString(String str) {
		String[] toks = str.split(",");
		return new Song(toks[0], Integer.parseInt(toks[1]), Integer.parseInt(toks[2]));
	}
}