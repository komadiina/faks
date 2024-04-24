package org.unibl.etf.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileRWBuffered {
		public static void main(String[] args) throws IOException {
			try (BufferedReader br = new BufferedReader(new FileReader("studenti.txt"));
				 PrintWriter pw = new PrintWriter(new FileWriter("test.txt"))) {
				String line;
				while((line = br.readLine())!=null) {
					System.out.println(line);
					pw.write(line);
				}
			}
			
		}
	}
