package primjer_ispitnih.prvi.parsing;

import primjer_ispitnih.prvi.Faktura;
import primjer_ispitnih.prvi.FakturaStavka;
import primjer_ispitnih.prvi.Tip;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.List;

public class FakturaParser extends Parser<Faktura> {
    public FakturaParser(String fileName) {
        super(fileName);
    }

    @Override
    public void run() {
        try {
            List<String> lines = Files.readAllLines(Path.of(this.fileName));

            for (String line : lines) {
                this.checkPause();

                System.out.printf("FParsiranje: %1$s%n", line);

                if (line.startsWith(Tip.FAKTURA.message)) {
                    Faktura parsed = new Faktura().fromString(line);

                    if (!this.data.containsKey(parsed.sifra))
                        this.data.put(parsed.sifra, parsed);
                }
                if (line.startsWith(Tip.FAKTURA_STAVKA.message)) {
                    FakturaStavka parsed = new FakturaStavka().fromString(line);

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
