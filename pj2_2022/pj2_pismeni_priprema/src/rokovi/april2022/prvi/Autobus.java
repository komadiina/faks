package rokovi.april2022.prvi;

import java.util.Random;

public final class Autobus extends Vozilo {
    public Autobus() {
        super(
                new Vozac("testVozacIme", "testVozacPrezime"),
                1 + (new Random()).nextInt(3),
                Utils.generisiMotor()
        );
    }

    public boolean trebaPrevesti() {
        return true;
    }
}
