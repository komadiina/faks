package rokovi.okt2022.treci;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Firma firma = new Firma();

        // Kreiranje artikala
        Artikal artikal1 = new Artikal("Artikal 1", 10.0, "123456789");
        Artikal artikal2 = new Artikal("Artikal 2", 15.0, "987654321");
        Artikal artikal3 = new Artikal("Artikal 3", 8.5, "456789123");

        Rafa rafa1 = new Rafa("Rafa 1");
        rafa1.dodajArtikal(artikal1, 5);
        rafa1.dodajArtikal(artikal2, 3);

        Rafa rafa2 = new Rafa("Rafa 2");
        rafa2.dodajArtikal(artikal1, 2);
        rafa2.dodajArtikal(artikal3, 4);

        Rafa rafa3 = new Rafa("Rafa 3");
        rafa3.dodajArtikal(artikal2, 4);
        rafa3.dodajArtikal(artikal3, 6);

        Skladiste skladiste1 = new Skladiste("Adresa 1");
        skladiste1.dodajRafu(rafa1);

        Skladiste skladiste2 = new Skladiste("Adresa 2");
        skladiste2.dodajRafu(rafa1);
        skladiste2.dodajRafu(rafa2);

        Skladiste skladiste3 = new Skladiste("Adresa 3");
        skladiste3.dodajRafu(rafa1);
        skladiste3.dodajRafu(rafa3);

        // Dodavanje skladišta u firmu
        firma.skladista.addAll(Arrays.asList(skladiste1, skladiste2, skladiste3));

        String barkod = "123456789";
        firma.ukupnaKolicinaArtikla(barkod);

        firma.ukupnoFinansijskoStanje();

        firma.rafeNajviseArtikala();

        firma.poUkupnomBrojuArtikala();
    }
}
