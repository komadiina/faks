import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;

public class Teleekran extends Thread {
	public static Deque<Poruka> poruke = new ArrayDeque<>();
	public static final Object queueZauzetLock = new Object();
	public static final Object stiglaPorukaLock = new Object();
	public static final Object prepravljacLock = new Object();
	public static final Object nadzornikLock = new Object();
	public static final Object zvono = new Object();
	public static boolean running = true;
	public static boolean pauza = false;
	
	@Override
	public void run() {
		while (running) {
			synchronized (Teleekran.stiglaPorukaLock) {
				try {
					Teleekran.stiglaPorukaLock.wait();
				} catch (InterruptedException ex) {
					// ex.printStackTrace();
					break;
				}
			}
			
			synchronized (Teleekran.prepravljacLock) { 
				Teleekran.prepravljacLock.notify();
			}
			
			provjeriPauzu();
		}
	}
	
	public void provjeriPauzu() {
		if (Teleekran.pauza) {
			synchronized (Teleekran.zvono) {
				try { 
					Teleekran.zvono.wait(); 
				} catch (InterruptedException ex)  { 
					ex.printStackTrace(); 
				}
			}
		} 
	}
	
	public static void prikaziPoruku(String msg) {
		System.out.printf("Nadzornik porucuje: %1$s.%n", msg);
	}
	
	public static synchronized Poruka uzmiPoruku() {
//		return poruke.poll();
		return poruke.pollLast();
	}
	
	public static synchronized void smjestiPoruku(Poruka p) {
		poruke.add(p); // izmijenjene poruke se stavljaju na kraj reda
	}
	
	public static synchronized Poruka pogledajZadnjuPoruku() {
		return poruke.peekLast();
	}
}
