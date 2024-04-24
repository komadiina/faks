package lab12_streams.treci;

public class Knjiga {
    Integer redniBroj, godinaObjavljivanja, godinaIzdavanja;
    String naslov, originalniNaslov, izdavac, pisac;
    String datumKupovine;

    public Knjiga(Integer redniBroj, Integer godinaObjavljivanja, Integer godinaIzdavanja,
                  String naslov, String originalniNaslov, String izdavac, String pisac,
                  String datumKupovine) {
        this.redniBroj = redniBroj;
        this.godinaObjavljivanja = godinaObjavljivanja;
        this.godinaIzdavanja = godinaIzdavanja;
        this.naslov = naslov;
        this.originalniNaslov = originalniNaslov;
        this.izdavac = izdavac;
        this.pisac = pisac;
        this.datumKupovine = datumKupovine;
    }

    public String toCSV() {
        return String.format("%1$d,%2$s,%3$s,%4$d,%5$s,%6$d,%7$s,%8$s%n",
                this.redniBroj, this.naslov, this.originalniNaslov,
                this.godinaObjavljivanja, this.pisac,
                this.godinaIzdavanja, this.izdavac,
                this.datumKupovine);
    }

    public Integer getRedniBroj() {
        return redniBroj;
    }

    public Integer getGodinaObjavljivanja() {
        return godinaObjavljivanja;
    }

    public Integer getGodinaIzdavanja() {
        return godinaIzdavanja;
    }

    public String getNaslov() {
        return naslov;
    }

    public String getOriginalniNaslov() {
        return originalniNaslov;
    }

    public String getIzdavac() {
        return izdavac;
    }

    public String getPisac() {
        return pisac;
    }

    public String getDatumKupovine() {
        return datumKupovine;
    }
}
