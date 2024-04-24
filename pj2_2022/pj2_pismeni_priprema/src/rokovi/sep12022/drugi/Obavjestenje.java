package rokovi.sep12022.drugi;

public abstract class Obavjestenje extends Element {
    public String naslov, opis;

    public Obavjestenje(String naslov, String opis) {
        this.naslov = naslov;
        this.opis = opis;
    }

    @Override
    public void akcija() {
        System.out.println(this.naslov);
    }

    @Override
    public String toString() {
        return "Obavjestenje{" +
                "naslov='" + naslov + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
