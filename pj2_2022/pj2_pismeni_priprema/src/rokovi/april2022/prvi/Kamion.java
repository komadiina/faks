package rokovi.april2022.prvi;

import java.util.*;

public final class Kamion extends Vozilo implements Prikolica {
    public Queue<Automobil> uPrikolici = new ArrayDeque<>();

    public Kamion() {
        super(
                new Vozac("testVozacIme", "testVozacPrezime"),
                1 + (new Random()).nextInt(3),
                Utils.generisiMotor()
        );
    }

    public void utovari(Automobil auto) {
        uPrikolici.add(auto);
    }
    public Automobil istovari() {
        return uPrikolici.poll();
    }

    public boolean trebaPrevesti() {
        return uPrikolici.size() > 0;
    }
}
