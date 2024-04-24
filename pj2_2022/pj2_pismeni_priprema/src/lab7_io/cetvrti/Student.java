package lab7_io.cetvrti;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class Student {
    Double prva, druga, treca, cetvrta;
    String indeks;

    public Student(String indeks, Double prva, Double druga, Double treca, Double cetvrta) {
        this.indeks = indeks;
        this.prva = prva;
        this.druga = druga;
        this.treca = treca;
        this.cetvrta = cetvrta;
    }

    @Override
    public String toString() {
        return String.format("%1$s %2$.2f %3$.2f %4$.2f %5$.2f",
                this.indeks, this.prva, this.druga, this.treca, this.cetvrta);
    }

    public boolean saveToFile(String directory) {
        String indeksOutput = this.indeks.replaceAll("/", "_");

        File record = new File(directory + File.separator + indeksOutput + ".txt");
        if (!record.exists())
            try {
                System.out.println(record.toPath());
                record.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }

        try (FileWriter writer = new FileWriter(record)) {
            writer.write(String.format("%1$s %2$.2f %3$.2f %4$.2f %5$.2f",
                    this.indeks, this.prva, this.druga, this.treca, this.cetvrta));
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
}
