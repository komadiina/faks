import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;

public class Main {
	public static void main(String[] args) {
		PrepravljanjeRijeci.dodajPrepravku("ljubav", "mrznja");
		PrepravljanjeRijeci.dodajPrepravku("sloboda", "nadzor");
		PrepravljanjeRijeci.dodajPrepravku("neznanje", "moc");
		PrepravljanjeRijeci.dodajPrepravku("nesto", "nestodrugo");
		PrepravljanjeRijeci.dodajPrepravku("broj", "slovo");
		PrepravljanjeRijeci.dodajPrepravku("faks", "nista");
		PrepravljanjeRijeci.dodajPrepravku("vrijeme", "prezent");
		
		Nadzornik nad = new Nadzornik("polis", "ofisr", "123456789");
		Radnik r1 = new Radnik("radnik1", "jadan", "111", 1250.0);
		Radnik r2 = new Radnik("radnik2", "zalostivi", "222", 1669.0);
		Prepravljac prep = new Prepravljac("onaj", "stoprepravlja", "666_666");
		
		London.radnici.add(r1); London.radnici.add(r2);
		London.stanovnici = new HashSet<>(Arrays.asList(nad, r1, r2, prep));
		
		System.out.println(London.radnici);
		System.out.println(London.stanovnici);
		
		Teleekran te = new Teleekran();
		KeyboardListenerThread klt = new KeyboardListenerThread(te, nad);
		
		klt.start();
		te.start();
		
		for (Stanovnik st : London.stanovnici)
			st.start();
		
		try {
			r1.posaljiPoruku(r2, "r1:poruka1 ljubav");
			Thread.sleep(1000);
			
			r1.posaljiPoruku(r2, "r1:poruka1 ljubav");
			Thread.sleep(1000);
			
			r1.posaljiPoruku(r2, "r1:poruka2 broj");
			Thread.sleep(1000);

			r1.posaljiPoruku(r2, "r1:poruka3 sve je ok");
			Thread.sleep(1000);
		
			r2.posaljiPoruku(r1, "r2:poruka1 vrijeme");
			Thread.sleep(1000);
			
			r2.posaljiPoruku(r1, "r2:poruka2 faks");
			Thread.sleep(1000);
			
			klt.join();
			te.join();
			

			for (Stanovnik st : London.stanovnici)
				st.join();
		
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
