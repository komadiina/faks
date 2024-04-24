package primjer_ispitnih.prvi;

import primjer_ispitnih.prvi.parsing.FakturaParser;
import primjer_ispitnih.prvi.parsing.NarudzbenicaParser;
import primjer_ispitnih.prvi.parsing.Parser;
import primjer_ispitnih.prvi.validating.Validator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static List<Faktura> fakture = new ArrayList<>();
    public static List<Narudzbenica> narudzbenice = new ArrayList<>();
    public static final String FILENAME = "data.csv";

    public static void main(String[] args) {
        // 1)
        process();

        System.out.println("--- FAKTURE ---");
        System.out.printf("Ukupno faktura: %1$d%n", fakture.size());
        fakture.forEach(item -> System.out.printf("%1$s -> %2$d%n", item.sifra, item.stavke.size()));

        System.out.println("--- NARUDZBENICE ---");
        System.out.printf("Ukupno narudzbenica: %1$d%n", fakture.size());
        narudzbenice.forEach(item -> System.out.printf("%1$s -> %2$d%n", item.sifra, item.stavke.size()));

        // 2)
        Predicate<Faktura> fUkupanIznos = f -> f.stavke.stream()
                .mapToDouble(s -> s.cijena * s.kolicina).sum() == f.ukupanIznos;
        Predicate<Faktura> fbrojStavki = f -> f.stavke.size() >= 1;

        Predicate<Narudzbenica> nBrojStavki = n -> n.stavke.size() >= 1;
        Predicate<Narudzbenica> nUkupanIznos = n -> n.stavke.stream()
                .filter(s -> (s.cijena * s.kolicina) < 0).toList().size() == 0;

        ArrayList<Predicate<Faktura>> fakturaPredikati = new ArrayList<>(Arrays.asList(fUkupanIznos, fbrojStavki));
        ArrayList<Faktura> vazeceFakture = new ArrayList<>(),
                nevazeceFakture = new ArrayList<>();

        fakture.forEach(f -> {
            if (Validator.validate(fakturaPredikati, f)) {
                vazeceFakture.add(f);
            } else {
                nevazeceFakture.add(f);
            }
        });

        ArrayList<Predicate<Narudzbenica>> narudzbenicaPredikati = new ArrayList<>(Arrays.asList(nBrojStavki, nUkupanIznos));
        ArrayList<Narudzbenica> vazeceNarudzbenice = new ArrayList<>(),
                nevazeceNarudzbenice = new ArrayList<>();

        narudzbenice.forEach(n -> {
           if (Validator.validate(narudzbenicaPredikati, n))
               vazeceNarudzbenice.add(n);
           else nevazeceNarudzbenice.add(n);
        });

        // 3)
        String txtFilename = args.length == 0 ? "out.txt" : args[1];
        Integer brojParsiranihFaktura = fakture.size(),
                brojParsiranihNarudzbenica = narudzbenice.size(),
                ukupanIznosFaktura = fakture.stream().mapToInt(s -> s.ukupanIznos).sum();
        Double prosjecanBrojStavkiNarudzbenica =
                vazeceNarudzbenice.stream().mapToDouble(n -> n.stavke.size()).average().orElse(0.0);

        String content = String.format("Broj parsiranih faktura: %1$d%nUkupan iznos: %2$d%n",
                brojParsiranihFaktura, ukupanIznosFaktura)
                + String.format("Broj parsiranih narudzbenica: %1$d%nProsjecan broj stavki: %2$.2f%n",
                brojParsiranihNarudzbenica, prosjecanBrojStavkiNarudzbenica);

        try {
            Files.write(Paths.get(txtFilename), content.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static void process() {
        NarudzbenicaParser nparser = new NarudzbenicaParser(FILENAME);
        FakturaParser fparser = new FakturaParser(FILENAME);
        KeyboardListenerThread klt = new KeyboardListenerThread(Arrays.asList(fparser, nparser));

        klt.start();
        nparser.start();
        fparser.start();

        try {
            fparser.join();
            nparser.join();

            klt.setActive(false);

            fakture = fparser.data.values().stream().toList();
            narudzbenice = nparser.data.values().stream().toList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
