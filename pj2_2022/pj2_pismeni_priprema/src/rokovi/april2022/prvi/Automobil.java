package rokovi.april2022.prvi;

import java.util.*;

public final class Automobil extends Vozilo {
    public Automobil() {
        super(
                new Vozac("testVozacIme", "testVozacPrezime"),
                1 + (new Random()).nextInt(8),
                Utils.generisiMotor()
        );
    }

    public boolean trebaPrevesti() {
        return true;
    }
}
