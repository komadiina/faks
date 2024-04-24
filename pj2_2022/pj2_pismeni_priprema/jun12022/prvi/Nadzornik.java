import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;

public class Nadzornik extends Stanovnik {
	public Nadzornik(String ime, String prezime, String jmbg) {
		super(ime, prezime, jmbg);
	}
	
	@Override
	public void run() {
		while (Teleekran.running) {
			synchronized (Teleekran.nadzornikLock) {
				try {
					Teleekran.nadzornikLock.wait();
				} catch (InterruptedException ex) { ex.printStackTrace(); }
				
				this.pregledajPoruku(Teleekran.pogledajZadnjuPoruku());
				
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
	
	public void pregledajPoruku(Poruka p) {
		for (Map.Entry<String, String> entry : PrepravljanjeRijeci.prepravke.entrySet()) {
			if (p.tekst.contains(entry.getValue())) // losa rijec
				kazniRadnika(nadjiRadnika(p.jmbgPosiljaoca));
		}
	}
	
	public void posaljiPorukuTeleekran(String msg) {
		Teleekran.prikaziPoruku(msg);
	}
	
	public void kazniRadnika(Radnik r) {
		Double x = 100.0 + (new Random()).nextDouble(900.0);
		r.plata -= x;
		Teleekran.prikaziPoruku(String.format("Zbog neadekvatnog ponasanja, radniku %1$s je plata umanjena za %2$.2f!%n",
				r.jmbg, x));
	}
	
	public Radnik nadjiRadnika(String jmbg) {
		for (Radnik r : London.radnici) {
			if (r.jmbg.equals(jmbg))
				return r;
		}
	
		return null;
	}
}