package org.unibl.etf.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) throws IOException {
		ArrayList<Student> students = new ArrayList<>();
		Path path = Paths.get("studenti.txt");
		List<String> lines = Files.readAllLines(path);
		for (String line : lines) {
			String elementi[] = line.split(";");
			students.add(new Student(elementi[0],elementi[1], elementi[2], Double.parseDouble(elementi[3])));
		}
		for (Student student : students) {
			System.out.println(student);
			System.out.println();
		}
	}

}
