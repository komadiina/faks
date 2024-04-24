package lab11_conc.treci;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        List<ProizvodnaTraka> trake = new ArrayList<>();
        trake.add(new ProizvodnaTraka("1", "telefon"));
        trake.add(new ProizvodnaTraka("2", "monitori"));
        trake.add(new ProizvodnaTraka("3", "odjeca"));

        for (ProizvodnaTraka traka : trake) {
            traka.start();

            // Delay cisto eto da ne bude isti seed
            try {
                sleep(563);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        try {
            for (ProizvodnaTraka traka: trake)
                traka.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // Analiza
        for (ProizvodnaTraka traka : trake)
            traka.analiza();
    }
}
