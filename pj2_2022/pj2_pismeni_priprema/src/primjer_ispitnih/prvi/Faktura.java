package primjer_ispitnih.prvi;

import java.util.*;

public class Faktura implements Converter<Faktura> {
    public String sifra, nazivKupca;
    public Integer ukupanIznos;
    public List<FakturaStavka> stavke = new ArrayList<>();

    public Faktura() {}

    public Faktura(String sifra, String nazivKupca, Integer ukupanIznos) {
        this.sifra = sifra;
        this.nazivKupca = nazivKupca;
        this.ukupanIznos = ukupanIznos;
    }

    public Faktura fromString(String str) {
        String[] toks = str.split(",");
        assert toks.length == 4;

        return new Faktura(toks[1], toks[2], Integer.parseInt(toks[3]));
    }
}
