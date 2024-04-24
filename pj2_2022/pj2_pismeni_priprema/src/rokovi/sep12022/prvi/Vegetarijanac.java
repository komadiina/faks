package rokovi.sep12022.prvi;

import java.util.Map;

public final class Vegetarijanac extends Gost {
    public Vegetarijanac(Double finansijskoStanje) {
        super(finansijskoStanje);
    }

    private void naruciJelo(Meni m) {
        for (Map.Entry<MeniStavka, Double> entry : m.spisak.entrySet()) {
            if (entry.getKey() instanceof Jelo j)
                if (j.zaVegetarijance &&  entry.getValue() <= this.finansijskoStanje)
                {
                    this.finansijskoStanje -= entry.getValue();
                }
        }
    }
}
