package lab7_io.cetvrti;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File dnevnik = new File("dnevnik.txt");
        List<Student> studenti = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(dnevnik.toPath());
            for (String line : lines) {
                // Redundancy
                line = line.replaceAll(",", ".");
                System.out.println(line);

                String[] tokens = line.split(" ");
                if (tokens.length != 5)
                {
                    System.err.printf("Malformed student record: %1$s%n", line);
                    continue;
                }

                studenti.add(new Student(
                        tokens[0],
                        Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]),
                        Double.parseDouble(tokens[4])
                ));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (Student st : studenti) {

            if (st.saveToFile(System.getProperty("user.dir"))) {
                System.out.printf("Saved student: %1$s%n", st.indeks);
            }
        }
    }
}
