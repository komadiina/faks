package rokovi.okt2022.treci;

import java.util.*;
import java.util.stream.Collectors;

public class Firma {
    public List<Skladiste> skladista = new ArrayList<>();

    public void ukupnaKolicinaArtikla(String barkod) {
        long kol = skladista.stream()
                .flatMap(skl -> skl.rafe.stream())
                .mapToLong(rafa -> rafa.brojArtikla(barkod))
                .sum();

        System.out.println(kol);
    }

    public void ukupnoFinansijskoStanje() {
        Double stanje = skladista.stream()
                .flatMap(skl -> skl.rafe.stream())
                .mapToDouble(Rafa::cijena)
                .sum();

        System.out.println(stanje);
    }

    public void rafeNajviseArtikala() {
        skladista.forEach(skl -> {
            Optional<Rafa> maxEntry =
                    skl.rafe.stream().max(Comparator.comparingInt(Rafa::kolicinaArtikala));

            System.out.println("Skladiste: " + skl.adresa);
            maxEntry.ifPresent(entry -> {
                System.out.println("Rafa: " + entry.oznaka);
            });
        });
    }

    public void poUkupnomBrojuArtikala() {
        List<Skladiste> sortirano = skladista.stream().sorted(Comparator.comparingInt(
                        skladiste -> -skladiste.rafe.stream()
                                .flatMap(rafa -> rafa.artikli.values().stream())
                                .mapToInt(Integer::intValue)
                                .sum()))
                .toList();

        System.out.println(sortirano);
    }
}
