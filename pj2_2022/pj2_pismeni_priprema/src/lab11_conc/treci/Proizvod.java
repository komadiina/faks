package lab11_conc.treci;

import java.io.Serializable;
import java.util.Random;

public final class Proizvod implements Serializable {
    public String serijskiBroj, ime;
    public boolean imaGresku;
    private Random rng = new Random();

    public Proizvod(String ime, String serijskiBroj) {
        this.ime = ime;
        this.serijskiBroj = serijskiBroj;
        this.imaGresku = rng.nextInt(100) < 50;
    }
}
