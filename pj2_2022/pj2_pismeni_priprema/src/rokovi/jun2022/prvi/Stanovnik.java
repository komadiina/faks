package rokovi.jun2022.prvi;

public abstract class Stanovnik extends Thread {
    String ime, prezime, maticniBroj;

    public Stanovnik(String ime, String prezime, String maticniBroj) {
        super();
        this.ime = ime;
        this.prezime = prezime;
        this.maticniBroj = maticniBroj;
    }
}
