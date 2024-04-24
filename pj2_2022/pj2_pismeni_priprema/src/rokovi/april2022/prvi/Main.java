package rokovi.april2022.prvi;

import java.util.*;

public class Main {
    public static final int
            BROJ_AUTOMOBILA = 5,
            BROJ_KAMIONA = 5,
            BROJ_AUTOBUSA = 5;

    public static void main(String[] args) {
        // Kreiraj vozila
        List<Vozilo> vozila = new ArrayList<>();

        for (int i = 0; i < BROJ_AUTOMOBILA; i++)
            vozila.add(new Automobil());

        for (int i = 0; i < BROJ_AUTOBUSA; i++)
            vozila.add(new Autobus());

        Random rng = new Random();
        for (int i = 0; i < BROJ_KAMIONA; i++) {
            Kamion k = new Kamion();
            if (rng.nextBoolean()) {
                int kolicina = rng.nextInt(2);
                while (kolicina-- >= 0)
                    k.utovari(new Automobil());
            }
            vozila.add(k);
        }

        GranicniPrelaz gp = new GranicniPrelaz(vozila);
        gp.start();
    }
}
