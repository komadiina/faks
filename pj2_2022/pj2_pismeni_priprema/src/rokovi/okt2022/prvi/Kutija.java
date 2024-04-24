package rokovi.okt2022.prvi;

import java.util.*;

public final class Kutija<T> extends Predmet {
    public List<T> sadrzaj = new ArrayList<>();

    public Kutija(Integer tezina, List<T> sadrzaj) {
        super(tezina);
        this.sadrzaj = sadrzaj;
    }

    public void otvori() {

    }

    public void zatvori() {

    }
}
