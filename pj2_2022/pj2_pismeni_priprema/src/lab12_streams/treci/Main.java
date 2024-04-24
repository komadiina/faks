package lab12_streams.treci;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Knjiga getKnjiga(String text) {
        String[] toks = text.split(",");
        assert toks.length == 8;

        // RB, NSLV, ORNSLV, GOD, PISC, GODIZDAV, IZDAV, DATKUP
        Integer redniBroj = Integer.parseInt(toks[0]);
        String naslov = toks[1];
        String originalniNaslov = toks[2];
        Integer godinaObjavljivanja = Integer.parseInt(toks[3]);
        String pisac = toks[4];
        Integer godinaIzdavanja = Integer.parseInt(toks[5]);
        String izdavac = toks[6];
        String datumKupovine = toks[7];

        return new Knjiga(
                redniBroj, godinaObjavljivanja, godinaIzdavanja,
                naslov, originalniNaslov, izdavac, pisac,
                datumKupovine
        );
    }

    private static List<Knjiga> getKnjige(String filename) {
        List<Knjiga> knjige = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            lines.removeIf(x -> x.contains("REDNI BROJ,")); // Drop header
            lines.forEach(x -> knjige.add(getKnjiga(x)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return knjige;
    }

    private static void writeToFile(List<Knjiga> knjige, String filename) {
        File file = new File(filename);

        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            for (Knjiga k : knjige)
                writer.write(k.toCSV());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Knjiga> knjige = getKnjige("KnjigeSpisak.csv");
        System.out.println(knjige.size());

        // a. sortiranje po naslovu, rastuce
        System.out.println("a)");
        List<Knjiga> sortirano = knjige.stream().sorted((a, b) -> a.naslov.compareTo(b.naslov)).toList();
        writeToFile(sortirano, "Sortirano_PoNaslovu.csv");

        // b. sortirane po godini objavljivanja, opadajuce
        System.out.println("b)");
        sortirano = knjige.stream().sorted((a, b) -> b.godinaObjavljivanja.compareTo(a.godinaObjavljivanja)).toList();
        writeToFile(sortirano, "Sortirano_GodinaObjavljivanja.csv");

        // c. knjige izdane u prvoj dekadi dvijehiljadite godine
        System.out.println("c)");
        List<Knjiga> filtered = knjige.stream().filter(
                x -> x.godinaIzdavanja >= 2000 && x.godinaIzdavanja < 2010
        ).toList();
        writeToFile(filtered, "Filtrirano_Dekada2K.csv");

        // d. po piscu (odabir korisnika)
//        System.out.println("d)");
//        Scanner scn = new Scanner(System.in);
//        String pisac = scn.nextLine();
//        scn.close();
//        filtered = knjige.stream().filter(
//                x -> x.pisac.equalsIgnoreCase(pisac)
//        ).toList();
//        writeToFile(filtered, "Filtrirano_" + pisac.replaceAll(" ", "_"));

        // e. sve knjige, grupisane po izdavacu (groupingBy)
        System.out.println("e)");
        Map<String, List<Knjiga>> grouped = knjige.stream().collect(Collectors.groupingBy(Knjiga::getIzdavac));
        System.out.println(Arrays.toString(grouped.entrySet().toArray()));

        // f. knjige sa originalnim naslovom od 3 do 5 rijeci
        System.out.println("f)");
        filtered = knjige.stream().filter(
                x -> {
                    Integer brojRijeci = x.naslov.split( " ").length;
                    return brojRijeci >= 3 && brojRijeci <= 5;
                }
        ).toList();
        writeToFile(filtered, "Knjige_Naslov3do5Rijeci.csv");

        // g. putem reduce(), izvrsiti sabiranje svih parnih rednih brojeva knjiga
        System.out.println("g)");
        Integer suma = knjige.stream().map(Knjiga::getRedniBroj).filter(redniBroj -> redniBroj % 2 == 0)
                .reduce(0, (a, b) -> a + b);
        System.out.printf("Suma: %1$d%n", suma);

        // h. godObj -> mapa integera, sumirati sve godine djeljive sa 3
        suma = knjige.stream().filter(x -> x.godinaObjavljivanja % 3 == 0)
                .mapToInt(Knjiga::getGodinaObjavljivanja).sum();
        System.out.printf("Suma: %1$d%n", suma);


        // i. sva slova u fajlu KnjigeSpisak.csv
        try {
            List<String> razlicitaSlova = Files.readAllLines(Path.of("KnjigeSpisak.csv")).stream()
                    .map(line -> line.split(""))
                    .flatMap(Arrays::stream)
                    .distinct().toList();
            System.out.println("Sva slova u fajlu: " + razlicitaSlova);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
