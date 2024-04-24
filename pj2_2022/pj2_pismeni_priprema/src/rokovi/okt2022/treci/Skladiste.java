package rokovi.okt2022.treci;

import java.util.*;

public class Skladiste {
    public List<Rafa> rafe;
    String adresa;

    public Skladiste(String adresa, List<Rafa> rafe) {
        this.rafe = rafe;
        this.adresa = adresa;
    }

    public Skladiste(String adresa) {
        this.adresa = adresa;
        this.rafe = new ArrayList<>();
    }

    public void dodajRafu(Rafa r) {
        this.rafe.add(r);
    }
}
