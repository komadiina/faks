package rokovi.jun2022.prvi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class Prepravljac extends Stanovnik {
    public static Map<String, String> zamjene = new HashMap<>(Map.ofEntries(
            entry("ljubav", "mrznja"),
            entry("sloboda", "nadzor"),
            entry("neznanje", "moc"),
            entry("nesto", "nestodrugo"),
            entry("faks", "zatvor"),
            entry("majka", "otac"),
            entry("brat", "sestra")
    ));

    public Prepravljac(String ime, String prezime, String maticniBroj) {
        super(ime, prezime, maticniBroj);
    }

    public void run() {
        while (BigBrother.running) {
            synchronized (PorukeBuffer.porukaStigla) {
                try{
                    PorukeBuffer.porukaStigla.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            // Stigla poruka, izmijeni
            Poruka zaIzmjenu = PorukeBuffer.poruke.peek();
            if (zaIzmjenu != null)
                zaIzmjenu.izmijeniTekst(izmijeni(zaIzmjenu.tekstPoruke));
        }
    }

    public String izmijeni(String sadrzaj) {
        String[] tokeni = sadrzaj.split(" ");
        for (String tok : tokeni)
            if (Prepravljac.zamjene.containsKey(tok))
                tok = zamjene.get(tok);

        return String.join(" ", tokeni);
    }
}
