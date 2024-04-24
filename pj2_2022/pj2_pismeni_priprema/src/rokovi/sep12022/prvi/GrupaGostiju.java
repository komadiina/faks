package rokovi.sep12022.prvi;

import java.util.*;

public class GrupaGostiju extends Thread {
    public static Integer ID = 0;
    public String idGrupe = (++ID).toString();

    List<Gost> gosti = new ArrayList<>();
    public boolean odbijeni = false;

    public GrupaGostiju(Integer kolicina) {
        Random rng = new Random();

        while (gosti.size() < kolicina) {
            if (rng.nextInt(100) < 20)
                gosti.add(new Pusac(200 + rng.nextDouble(5000)));

            else if (rng.nextInt(100) < 20)
                gosti.add(new Vegetarijanac(200 + rng.nextDouble(5000)));

            else
                gosti.add(new Gost(200 + rng.nextDouble(5000)));
        }
    }

    public Double usluziMeni(Meni meni) {
        Double racun = 0.0;
        for (Gost g : gosti)
            racun += g.pogledajMeni(meni);
        return racun;
    }

    public void uzivaj() {
        System.out.printf("Grupica %1$s uziva.%n", this.idGrupe);
    }

    public Double sumarnoNovca() {
        return this.gosti.stream().mapToDouble(x -> x.finansijskoStanje).sum();
    }

    public boolean sadrziPusace() {
        for (Gost g : gosti)
            if (g instanceof Pusac p)
                return true;

        return false;
    }

    public boolean sadrziVegetarijance() {
        for (Gost g : gosti)
            if (g instanceof Vegetarijanac veg)
                return true;

        return false;
    }

    public Integer brojGostiju() {
        return this.gosti.size();
    }
}
