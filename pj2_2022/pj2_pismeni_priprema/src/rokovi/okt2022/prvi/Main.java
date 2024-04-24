package rokovi.okt2022.prvi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Firma firma = new Firma();
        List<Predmet> proizvodi = new ArrayList<>();

        // sajle
        List<CelicnaSajla> cSajle = new ArrayList<>(Arrays.asList(
                new CelicnaSajla(15), new CelicnaSajla(16),
                new CelicnaSajla(11), new CelicnaSajla(20),
                new CelicnaSajla(14)
        ));
        List<InoxSajla> iSajle = new ArrayList<>(Arrays.asList(
                new InoxSajla(2), new InoxSajla(4), new InoxSajla(6),
                new InoxSajla(1), new InoxSajla(3)
        ));

        // Kutije
        List<String> sadrzaj = new ArrayList<>(Arrays.asList("spicangle", "komibinirke", "rolcange", "francuski kljuc"));
        List<Kutija<String>> kutije = new ArrayList<>(Arrays.asList(
                new Kutija<String>(20, sadrzaj), new Kutija<String>(15, sadrzaj),
                new Kutija<String>(25, sadrzaj), new Kutija<String>(40, sadrzaj),
                new Kutija<String>(35, sadrzaj)
        ));

        // Ploce
        List<Ploca> ploce = new ArrayList<>(Arrays.asList(
                new Ploca(1), new Ploca(2), new Ploca(3), new Ploca(4), new Ploca(5)
        ));

        proizvodi.addAll(cSajle); proizvodi.addAll(iSajle); proizvodi.addAll(kutije); proizvodi.addAll(ploce);
        Collections.shuffle(proizvodi);

        // Radnici
        List<Radnik> radnici = new ArrayList<>(Arrays.asList(
                new Varioc("vario", "mario", 1965),
                new VozacKamiona("moco", "pavlovic", 1955),
                new VozacViljuskara("marko", "grbic", 2001),
                new Bravar("ognjen", "komadina", 2001)
        ));

        Firma.radnici = radnici;
        Firma.skladiste = proizvodi;
        KeyboardListenerThread klt = new KeyboardListenerThread();

        klt.start();
        firma.start();

        try {
            klt.join();
            firma.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.printf("Broj obradjenih: %1$d, broj neobradjenih: %2$d.%n",
                Firma.brojObradjenih, 0);
    }
}
