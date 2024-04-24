package rokovi.april2022.prvi;

import java.util.*;

public class GranicniPrelaz {
    public final static int DUZINA_PUTA = 15;
    public static Vozilo[] put;
    public List<Vozilo> vozila = new ArrayList<>();
    public static List<Terminal> terminali = new ArrayList<>();

    public GranicniPrelaz(List<Vozilo> vozila) {
        assert vozila.size() == DUZINA_PUTA;
        put = new Vozilo[DUZINA_PUTA];

        Collections.shuffle(vozila);
        for (int i = 0; i < vozila.size(); i++)
            put[i] = vozila.get(i);

        this.vozila = vozila;
    }

    public void dodajTerminal(Terminal term) {
        terminali.add(term);
    }

    public void start() {
        // Pokreni terminale
        for (Terminal t : terminali)
            t.start();

        // Pokreni vozila
        for (int i = 0; i < put.length; i++)
            put[i].start();

        // Cekaj
        try {
            for (Vozilo v : vozila) {
                v.join();
                System.out.printf("%1$s zavrsilo.%n", v.id);
            }

            for (Terminal t: terminali)
            {
                t.running = false;
                synchronized (t.cekanjeLock) {
                    t.cekanjeLock.notify();
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("--- Zavrsena simulacija ---");
        this.report();
    }

    public void report() {
        Integer ukupnaNaplacenaTaksa = terminali.stream().mapToInt(t -> t.ukupnoTakse).sum();
        Integer ukupnoProsloPutnika = terminali.stream().mapToInt(t -> t.prosloPutnika).sum();

        System.out.printf("Ukupna naplacena taksa: %1$d%nProslo putnika: %2$d%n",
                ukupnaNaplacenaTaksa, ukupnoProsloPutnika);
    }
}
