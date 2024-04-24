package primjer_ispitnih.prvi;

public class NarudzbenicaStavka implements Converter<NarudzbenicaStavka> {
    public String sifra, naziv;
    public Integer kolicina;
    public Integer cijena;

    public NarudzbenicaStavka() {}

    public NarudzbenicaStavka(String sifra, String naziv, Integer kolicina, Integer cijena) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.kolicina = kolicina;
        this.cijena = cijena;
    }

    public NarudzbenicaStavka fromString(String str) {
        String[] toks = str.split(",");
        assert toks.length == 5;

        return new NarudzbenicaStavka(toks[1], toks[2], Integer.parseInt(toks[3]), Integer.parseInt(toks[4]));
    }
}
