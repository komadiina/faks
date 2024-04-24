package rokovi.sep12022.prvi;

import java.util.*;

public class Stol {
    public List<Gost> participanti;
    public final Integer kapacitet;
    public boolean zauzet = false;

    public Stol(Integer kapacitet, List<Gost> participanti) {
        assert participanti.size() <= kapacitet;
        assert kapacitet == 2 || kapacitet == 4 || kapacitet == 6;

        this.participanti = participanti;
        this.kapacitet = kapacitet;
    }
}
