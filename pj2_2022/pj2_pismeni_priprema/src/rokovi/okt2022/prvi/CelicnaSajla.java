package rokovi.okt2022.prvi;

import java.util.Random;

public final class CelicnaSajla extends Sajla {
    public CelicnaSajla(Integer tezina) {
        super(tezina);
    }

    public void obradi() {
        this.ostecen = (new Random()).nextInt() < 7;
        this.obradjen = true;
    }
}
