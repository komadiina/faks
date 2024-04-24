package rokovi.okt2022.prvi;

import java.util.*;

public final class InoxSajla extends Sajla {
    public InoxSajla(Integer tezina) {
        super(tezina);
    }

    public void obradi() {
        this.ostecen = (new Random()).nextInt() < 3;
        this.obradjen = true;
    }
}
