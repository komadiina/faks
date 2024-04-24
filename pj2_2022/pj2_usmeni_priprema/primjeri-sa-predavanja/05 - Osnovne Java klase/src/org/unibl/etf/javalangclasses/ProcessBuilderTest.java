package org.unibl.etf.javalangclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderTest {

	public static void main(String[] args) {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("C:\\Program Files\\Mozilla Firefox\\firefox.exe", "etf.unibl.org");
		try {
			Process process = processBuilder.start();
			Thread.sleep(8000);
	        processBuilder.command("cmd.exe", "/c", "ping -n 20 www.google.com");
	        process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			int exitCode = process.waitFor();
			System.out.println("\nExit code : " + exitCode);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
