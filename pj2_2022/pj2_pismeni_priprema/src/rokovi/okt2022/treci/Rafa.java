package rokovi.okt2022.treci;

import java.util.*;

public class Rafa {
    public String oznaka;
    public Map<Artikal, Integer> artikli;

    public Rafa(String oznaka, Map<Artikal, Integer> artikli) {
        this.oznaka = oznaka;
        this.artikli = artikli;
    }

    public Rafa(String oznaka) {
        this.oznaka = oznaka;
        this.artikli = new HashMap<>();
    }

    public void dodajArtikal(Artikal art, int kol) {
        artikli.put(art, kol);
    }

    public long brojArtikla(String barkod) {
        long brojArtikala =0;

        for (Map.Entry<Artikal, Integer> entry : artikli.entrySet())
            if (entry.getKey().barkod.equals(barkod))
                brojArtikala += entry.getValue();

        return brojArtikala;
    }

    public List<Artikal> getArtikli() {
        return new ArrayList<>(artikli.keySet());
    }

    public Double cijena() {
        Double cijena = 0.0;

        for (Map.Entry<Artikal, Integer> entry : artikli.entrySet())
            cijena += (entry.getValue() * entry.getKey().cijena);

        return cijena;
    }

    public int kolicinaArtikala() {
        int kol = 0;

        for (Map.Entry<Artikal, Integer> entry : artikli.entrySet())
            kol += entry.getValue();

        return kol;
    }
}
