package rokovi.sep12022.prvi;

import java.util.*;

public class Gost {
    public Double finansijskoStanje;
    private static Integer ID = 0;
    public String id = (++ID).toString();

    public Gost(Double finansijskoStanje) {
        this.finansijskoStanje = finansijskoStanje;
    }

    public Double pogledajMeni(Meni m) {
        Double iznos = naruciPice(m);
        iznos += naruciJelo(m);
        return iznos;
    }

    private Double naruciJelo(Meni m) {
        for (Map.Entry<MeniStavka, Double> entry : m.spisak.entrySet()) {
            if (entry.getKey() instanceof Jelo j)
                if (entry.getValue() <= this.finansijskoStanje) {
                    this.finansijskoStanje -= entry.getValue();
                    return entry.getValue();
                }
        }

        return 0.0;
    }

    private Double naruciPice(Meni m) {
        for (Map.Entry<MeniStavka, Double> entry : m.spisak.entrySet()) {
            if (entry.getKey() instanceof Pice p)
                if (entry.getValue() <= this.finansijskoStanje) {
                    this.finansijskoStanje -= entry.getValue();
                    return entry.getValue();
                }
        }

        return 0.0;
    }
}
