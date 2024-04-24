import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;

public class Main {
	public static String PUTANJA = "";

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++)
			if (args[i].equals("--putanja"))
				PUTANJA = args[i + 1];
			
		PUTANJA = System.getProperty("user.dir") + File.separator + PUTANJA;
		
		FileWatcher watcher = new FileWatcher(PUTANJA);
		watcher.start();
		
		try {
			watcher.join();
		} catch (Exception ex) { ex.printStackTrace(); }
	}
}