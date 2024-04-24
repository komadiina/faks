import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;

public class Prepravljac extends Stanovnik {
	public Prepravljac(String ime, String prezime, String jmbg) {
		super(ime, prezime, jmbg);
	}
	
	@Override
	public void run() {
		while (Teleekran.running) {
			synchronized (Teleekran.prepravljacLock) {
				try {
					Teleekran.prepravljacLock.wait();
				} catch (InterruptedException ex) { ex.printStackTrace(); }
				
				Poruka prepravljena = prepraviPoruku(Teleekran.uzmiPoruku());
				Teleekran.smjestiPoruku(prepravljena);
				
				synchronized (Teleekran.nadzornikLock) {
					Teleekran.nadzornikLock.notify();
				}
				
				provjeriPauzu();
			}
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
	
	public Poruka prepraviPoruku(Poruka p) {
		for (Map.Entry<String, String> entry : PrepravljanjeRijeci.prepravke.entrySet()) {
			if (p.tekst.contains(entry.getKey()))
				p.tekst = p.tekst.replaceAll(entry.getKey(), String.format("[%1$s]", entry.getValue()));
		}
		
		System.out.println("----- Sadrzaj prepr. poruke: " + p.tekst);
		
		return p;
	}
}