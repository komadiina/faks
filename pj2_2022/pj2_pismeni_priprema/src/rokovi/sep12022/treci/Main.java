package rokovi.sep12022.treci;

import java.nio.file.*;
import java.nio.*;
import java.io.*;
import java.nio.file.attribute.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    // File
    public static List<String> pretraziA(String folder) {
        List<String> content = new ArrayList<>();

        try {
            Files.walkFileTree(Path.of(folder),
                    new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                            content.add(file.getFileName().toString());
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult postVisitDirectory(Path dir, IOException ex) throws IOException {
                            if (ex == null) {
                                content.add(dir.toString());
                                return FileVisitResult.CONTINUE;
                            }
                            else throw ex;
                        }
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return content;
    }

    public static List<String> pretraziB(String folder) {
        File trenutniDir = new File(folder);

        List<String> content = new ArrayList<>();
        if (trenutniDir.isDirectory())
            content.addAll(pretraziRekUtil(trenutniDir));
        else
            content.add(folder); // fajl

        return content;
    }

    public static List<String> pretraziRekUtil(File direktorijum) {
        List<String> content = new ArrayList<>();

        for (File entry : direktorijum.listFiles()) {
            if (entry.isFile())
                content.add(entry.toPath().getFileName().toString());
            else
                content.addAll(pretraziRekUtil(entry));
        }

        return content;
    }

    public static void main(String[] args) {
        assert args.length == 3;
        String putanja = System.getProperty("user.dir");

        for (int i = 0; i < args.length; i++)
            if (args[i].equals("--putanja"))
                putanja = args[i+1];

        List<String> sadrzaj = pretraziA(putanja);

        for (String entry : sadrzaj)
            try {
                Files.write(Paths.get("rezultati.txt"), entry.getBytes());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        // folderi -> fajlovi -> naziv/rastuce
        List<String> direktorijumi = sadrzaj.stream().filter(x -> x.contains("\\")).sorted().toList();
        List<String> fajlovi = sadrzaj.stream().filter(x -> !x.contains("\\")).sorted().toList();
        List<String> rezultat = new ArrayList<>();
        System.out.println("--- DIREKTORIJUMI ---");
        System.out.println(direktorijumi);

        System.out.println("--- FAJLOVI ---");
        System.out.println(fajlovi);

        rezultat.addAll(direktorijumi); rezultat.addAll(fajlovi);
        prettyPrint(rezultat);

        // duzina 4
        rezultat.clear();
        rezultat = direktorijumi.stream().filter(x -> {
            String[] potfolderi = x.split("/");
            return potfolderi.length >= 4;
        }).toList();
        prettyPrint(rezultat);

        // grupisane po ekstenziji
        Object rez = fajlovi.stream().collect(Collectors.groupingBy(x -> {
            Integer indeksTacke = x.lastIndexOf(".");
            if (indeksTacke > 0)
                return x.substring(indeksTacke);
            return 0;
        }));
        System.out.println(rez);

        // fajlovi koji pocinju sa A/a
        long broj = fajlovi.stream().filter(x -> x.toLowerCase().startsWith("a")).count();

        // mapa pojavljivanja fajlova istog naziva
        Map<String, Long> brojPojavljivanja = fajlovi.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(brojPojavljivanja);
    }

    private static void prettyPrint(List<String> list) {
        for (String line : list)
            System.out.println(line);
    }
}
