package rokovi.sep22022.treci;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Vozilo> vozila1 = new LinkedList<>(Arrays.asList(
                new Vozilo(2007, 5, 108, Tip.SEDAN, Boja.CRVENA),
                new Vozilo(2009, 5, 133, Tip.KARAVAN, Boja.BIJELA),
                new Vozilo(2010, 2, 420, Tip.SEDAN, Boja.PLAVA),
                new Vozilo(1999, 5, 200, Tip.SUV, Boja.CRVENA),
                new Vozilo(1988, 8, 60, Tip.SUV, Boja.BIJELA))
        );
        LinkedList<Vozilo> vozila2 = new LinkedList<>(Arrays.asList(
                new Vozilo(2007, 5, 150, Tip.SEDAN, Boja.BIJELA),
                new Vozilo(2009, 5, 133, Tip.KARAVAN, Boja.CRVENA),
                new Vozilo(2010, 2, 420, Tip.SEDAN, Boja.PLAVA),
                new Vozilo(1999, 5, 999, Tip.SUV, Boja.BIJELA),
                new Vozilo(1988, 8, 68, Tip.SUV, Boja.BIJELA))
        );

        LinkedList<Vozilo> crvenaVozila = new LinkedList<>(Stream.concat(vozila1.stream(), vozila2.stream())
                .filter(x -> x.snaga > 120 && x.boja.equals(Boja.CRVENA)).toList());

        System.out.println(crvenaVozila);

        LinkedList<Vozilo> sortirano = new LinkedList<>(Stream.concat(vozila1.stream(), vozila2.stream()).
                sorted(Comparator.comparingInt(x -> x.godina)).toList());

        System.out.println(sortirano);

        Integer brojSjedistaSuv = (Stream.concat(vozila1.stream(), vozila2.stream()))
                .filter(x -> x.tip.equals(Tip.SUV) && x.godina <= 2000).mapToInt(x -> x.brojSjedista).sum();

        System.out.println(brojSjedistaSuv);

        double prosjecnaSnaga = (Stream.concat(vozila1.stream(), vozila2.stream()))
                .mapToInt(x -> x.snaga).average().orElse(0);

        Vozilo najblize = (Stream.concat(vozila1.stream(), vozila2.stream()))
                .min((v1, v2) -> Math.toIntExact(Math.round(Math.abs(v1.snaga - prosjecnaSnaga) - (Math.abs(v2.snaga) - prosjecnaSnaga))))
                .orElse(null);

        System.out.println(najblize);
    }
}
