package rokovi.jan12023.prvi;

import java.util.*;

public final class Liga {
    public String naziv;
    public List<Tim> timovi;
    public BowlingAlley staza = new BowlingAlley();

    public List<Tim> pobjednici = new ArrayList<>();

    public Liga(String naziv, List<Tim> timovi) {
        this.naziv = naziv;
        this.timovi = timovi;
    }
}
