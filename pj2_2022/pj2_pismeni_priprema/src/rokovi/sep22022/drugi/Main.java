package rokovi.sep22022.drugi;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<String> pretrazi(Boolean isCaseSensitive) {
        // pocetni dir == PUTANJA
        List<String> rezultati = new ArrayList<>();

        try {
            Files.walkFileTree(Path.of(PUTANJA), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    String name = file.toString();

                    // Case-Sensitive
                    if (!isCaseSensitive) {
                        name = name.toLowerCase();
                        if (name.contains(RIJEC.toLowerCase()) && name.endsWith(EKSTENZIJA.toLowerCase()))
                            rezultati.add(name);
                    }
                    // Case-Insensitive
                    else {
                        if (name.contains(RIJEC) && name.endsWith("." + EKSTENZIJA))
                            rezultati.add(name);
                    }

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException ex)
                        throws IOException {
                    if (ex == null)
                        return FileVisitResult.CONTINUE;
                    else throw ex;
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return rezultati;
    }

    public static String PUTANJA = "", RIJEC = "", EKSTENZIJA = "";

    public static void main(String[] args) {
        assert args.length > 7;

        for (int i = 0; i < args.length; i++)
            if (args[i].equals("-s"))
                PUTANJA = System.getProperty("user.dir") + File.separator + args[i + 1];
            else if (args[i].equals("-w"))
                RIJEC = args[i + 1];
            else if (args[i].equals("-e"))
                EKSTENZIJA = args[i + 1];

        System.out.println(EKSTENZIJA + " " + RIJEC + " " + PUTANJA);

        Map<String, Long> rezultatiCount = pretrazi(false).stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        for (Map.Entry<String, Long> entry : rezultatiCount.entrySet())
            System.out.printf("%1$s -> %2$d%n",
                    entry.getKey(), entry.getValue());
    }
}
