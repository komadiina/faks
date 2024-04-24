package rokovi.jun2022.prvi;

import java.util.*;
import java.time.*;

public final class Radnik extends Stanovnik {
    public Integer plata;

    public Radnik(String ime, String prezime, String maticniBroj, Integer plata) {
        super(ime, prezime, maticniBroj);
        this.plata = plata;
    }

    public boolean posaljiPoruku(Radnik recipijent, String sadrzaj) {
        Poruka por = new Poruka(
                this.maticniBroj,
                recipijent.maticniBroj,
                LocalDateTime.now().toLocalTime().toString(),
                sadrzaj
        );

        PorukeBuffer.bufferujPoruku(por);

        return true;
    }

    public void run() {
        while (BigBrother.running) {

        }
    }
}
