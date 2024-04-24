public class Narudzbenica {
    public String sifra;
    public String datumKupovine;
    public List<NarudzbenicaStavka> stavke;

    public Narudzbenica() {
    }

    public Narudzbenica(String sifra, String datumKupovine, List<NarudzbenicaStavka> stavke) {
        this.sifra = sifra;
        this.datumKupovine = datumKupovine;
        this.stavke = stavke;
    }

    public getsifra() {
        return this.sifra;
    }

    public setsifra(String sifra) {
        this.sifra = sifra;
    }

    public getdatumKupovine() {
        return this.datumKupovine;
    }

    public setdatumKupovine(String datumKupovine) {
        this.datumKupovine = datumKupovine;
    }

    public getstavke() {
        return this.stavke;
    }

    public setstavke(List<NarudzbenicaStavka> stavke) {
        this.stavke = stavke;
    }

    public Narudzbenica fromString(String str) {
    }

    @Override
    public String toString() {
        return String.format("sifra, datumKupovine, stavke, ");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof Narudzbenica p) {
            return this.sifra == p.sifra && this.datumKupovine == p.datumKupovine && this.stavke == p.stavke;
        }
        return false;
    }
}
