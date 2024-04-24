package rokovi.okt2022.prvi;

import java.util.Random;

public abstract class Predmet {
    protected static Integer ID = 0;
    public boolean ostecen = false, obradjen = false;
    public Integer tezina;
    public String id = (++ID).toString();

    public Predmet(Integer tezina) {
        this.tezina = tezina;
    }

    public void obradi() {
        this.ostecen = (new Random()).nextInt() < 6;
        this.obradjen = true;
    }
}
