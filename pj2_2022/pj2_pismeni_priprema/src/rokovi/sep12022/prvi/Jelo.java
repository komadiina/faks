package rokovi.sep12022.prvi;

public class Jelo extends MeniStavka {
    public boolean zaVegetarijance;

    public Jelo(String naziv, boolean zaVegetarijance) {
        super(naziv);
        this.zaVegetarijance = zaVegetarijance;
    }
}
