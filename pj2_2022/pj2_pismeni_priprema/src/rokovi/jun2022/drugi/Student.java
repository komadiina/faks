package rokovi.jun2022.drugi;

import java.util.*;

public class Student {
    String ime, prezime, indeks;
    List<String> slusa = new ArrayList<>();

    public Student(String ime, String prezime, String indeks, List<String> slusa) {
        this.ime = ime;
        this.prezime = prezime;
        this.indeks = indeks;
        this.slusa = slusa;
    }
}
