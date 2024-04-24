package rokovi.okt2022.drugi;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class CopyMaker extends Thread {
    File file;

    public void setFile(String filename) {
        this.file = new File(filename);
    }

    @Override
    public void run() {


        while (Document.modificationCount > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            List<String> content = new ArrayList<>();
            long izbacenoBrojeva = 0;
            long izmijenjenoSlovaO = 0;

            synchronized (Document.lock) {
                try {
                    content = Files.readAllLines(file.toPath());
                    List<String> modifiedContent = new ArrayList<>();

                    // Prebroj brojeve i oO
                    for (String str : content) {
                        for (char c : str.toCharArray())
                            if (Character.isDigit(c))
                                izbacenoBrojeva++;
                            else if (c == 'o' || c == 'O')
                                izmijenjenoSlovaO++;
                    }

                    // Izmijeni, out-of-place
                    for (String str : content) {
                        String modified = str.replaceAll("[0-9]", "");
                        modified = modified.replaceAll("[oO]", "0");
                        modifiedContent.add(modified);
                    }

                    PrintWriter pw = new PrintWriter(new FileWriter(Document.path, true));
                    modifiedContent.forEach(pw::println);
                    pw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            // Upisi u fajl rezultata
            try {
                PrintWriter pw = new PrintWriter(new FileWriter("rezultatiKopiranja.txt", true));
                pw.printf("[0-9]: %1$d, [oO]: %2$d%n", izbacenoBrojeva, izmijenjenoSlovaO);
                pw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            Document.modificationCount--;
        }
    }
}
