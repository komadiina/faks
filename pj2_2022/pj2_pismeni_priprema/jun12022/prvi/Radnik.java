import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;

public final class Radnik extends Stanovnik {
	Double plata;
	
	public Radnik(String ime, String prezime, String jmbg, Double plata) {
		super(ime, prezime, jmbg);
		this.plata = plata;
	}
	
	@Override
	public void run() {
		while (Teleekran.running) {
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

	public void posaljiPoruku(Radnik kome, String tekst) {
		Poruka p = new Poruka(this.jmbg, kome.jmbg, tekst, String.format("%1$d", (new Date()).getTime()));
		
		Teleekran.smjestiPoruku(p);  
		
		synchronized (Teleekran.stiglaPorukaLock) {
			Teleekran.stiglaPorukaLock.notify();
		}
	}
	
	@Override
	public String toString() {
		return String.format("%1$s [%2$.2f]", super.toString(), plata);
	}
}