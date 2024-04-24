package org.unibl.etf.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws Exception {
		ArrayList<Student> studenti = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("studenti.txt"));
		String linija;
		while((linija=br.readLine())!=null){
			String elementi[] = linija.split(";");
			studenti.add(new Student(elementi[0],elementi[1], elementi[2], Double.parseDouble(elementi[3])));
		}
		for (Student korisnik : studenti) {
			System.out.println(korisnik);
			System.out.println("=============");
		}
		br.close();
	}

}
