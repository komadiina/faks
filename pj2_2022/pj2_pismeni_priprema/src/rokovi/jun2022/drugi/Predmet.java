package rokovi.jun2022.drugi;

public class Predmet {
    private static Integer ID = 0;
    public String naziv, id = (++ID).toString();

    public Predmet() {
        naziv = "undefined";
    }

    public Predmet(String naziv, String id) {
        this.naziv = naziv;
        this.id = id;
    }
}
