package lab7_io.peti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Zaposleni implements Serializable {
    private List<Radnik> spisak;

    public Zaposleni(List<Radnik> spisak) {
        this.spisak = spisak;
    }

    public Zaposleni() {
        this.spisak = new ArrayList<>();
    }

    public Boolean imaZaposlen(Radnik r) {
        return spisak.contains(r);
    }

    public Boolean imaZaposlen(String username) {
        for (Radnik r : spisak)
            if (r.korisnickoIme.equals(username))
                return true;

        return false;
    }

    public void dodajZaposlenog(Radnik r) {
        this.spisak.add(r);
    }

    public Radnik getRadnik(String username) {
        for (Radnik r : spisak)
            if (r.korisnickoIme.equals(username))
                return r;

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Radnik r : this.spisak)
            sb.append(r);

        return sb.toString();
    }
}
