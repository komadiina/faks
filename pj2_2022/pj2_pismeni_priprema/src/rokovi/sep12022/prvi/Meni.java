package rokovi.sep12022.prvi;

import java.util.*;

public class Meni {
    public HashMap<MeniStavka, Double> spisak = new HashMap<>();

    public Meni(HashMap<MeniStavka, Double> spisak) {
        this.spisak = spisak;
    }

    public boolean imaVegetarijanskuHranu() {
        List<MeniStavka> jela = spisak.keySet().stream().filter(x -> x instanceof Jelo).toList();
        Boolean postoji = false;

        for (MeniStavka stavka : jela)
            if (((Jelo) stavka).zaVegetarijance) {
                postoji = true;
                break;
            }

        return postoji;
    }
}
