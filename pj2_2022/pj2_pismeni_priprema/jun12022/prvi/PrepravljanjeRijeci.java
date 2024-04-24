import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;

public class PrepravljanjeRijeci {
	public static Map<String, String> prepravke = new HashMap<>();
	
	public static void dodajPrepravku(String iz, String u) {
		prepravke.put(iz, u);
	}
	
	public static String uzmiIspravljenuRijec(String original) {
		return prepravke.get(original);
	}
	
	public static HashSet<String> loseRijeci() {
		return new HashSet<>(prepravke.values());
	}
	
	public static boolean jeLosaRijec(String rijec) {
		return prepravke.containsValue(rijec);
	}
}