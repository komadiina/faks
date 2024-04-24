package rokovi.okt2022.treci;

public class Artikal {
    public Double cijena;
    public String naziv, barkod;

    public Artikal(String naziv, Double cijena, String barkod) {
        this.naziv = naziv;
        this.cijena = cijena;
        this.barkod = barkod;
    }
}
