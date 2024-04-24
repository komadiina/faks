package primjer_ispitnih.prvi;

public class FakturaStavka implements Converter<FakturaStavka> {
    public String sifra, naziv;
    public Integer kolicina;
    public Integer cijena;

    public FakturaStavka() {}

    public FakturaStavka(String sifra, String naziv, Integer kolicina, Integer cijena) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.kolicina = kolicina;
        this.cijena = cijena;
    }

    @Override
    public FakturaStavka fromString(String str) {
        String[] toks = str.split(",");
        assert toks.length == 5;

        return new FakturaStavka(toks[1], toks[2], Integer.parseInt(toks[3]), Integer.parseInt(toks[4]));
    }
}
