package primjer_ispitnih.prvi.parsing;

import primjer_ispitnih.prvi.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class NarudzbenicaParser extends Parser<Narudzbenica> {
    public NarudzbenicaParser(String fileName) {
        super(fileName);
    }

    @Override
    public void run() {
        try {
            List<String> lines = Files.readAllLines(Path.of(this.fileName));

            for (String line : lines) {
                this.checkPause();

                System.out.printf("NParsiranje: %1$s%n", line);

                if (line.startsWith(Tip.NARUDZBENICA.message)) {
                    Narudzbenica parsed = new Narudzbenica().fromString(line);

                    if (!this.data.containsKey(parsed.sifra))
                        this.data.put(parsed.sifra, parsed);
                }
                if (line.startsWith(Tip.NARUDZBENICA_STAVKA.message)) {
                    NarudzbenicaStavka parsed = new NarudzbenicaStavka().fromString(line);

                    if (this.data.containsKey(parsed.sifra))
                        this.data.get(parsed.sifra).stavke.add(parsed);
                }

                try {
                    Thread.sleep(SPEED);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
