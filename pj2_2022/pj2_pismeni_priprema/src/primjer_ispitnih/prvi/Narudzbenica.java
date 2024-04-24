package primjer_ispitnih.prvi;
import java.util.*;

public class Narudzbenica implements Converter<Narudzbenica> {
    public String sifra, datumKupovine;
    public List<NarudzbenicaStavka> stavke = new ArrayList<>();

    public Narudzbenica() {}

    public Narudzbenica(String sifra, String datumKupovine) {
        this.sifra = sifra;
        this.datumKupovine = datumKupovine;
    }

    public Narudzbenica fromString(String str) {
        String[] toks = str.split(",");
        assert toks.length == 3;

        return new Narudzbenica(toks[1], toks[2]);
    }
}
