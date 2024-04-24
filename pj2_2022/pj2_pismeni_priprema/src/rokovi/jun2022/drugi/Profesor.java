package rokovi.jun2022.drugi;

import java.util.*;

public class Profesor {
    String ime, prezime, jmb;
    List<String> predaje = new ArrayList<>();

    public Profesor(String ime, String prezime, String jmb, List<String> predaje) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmb = jmb;
        this.predaje = predaje;
    }
}
