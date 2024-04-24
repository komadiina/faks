package lab11_conc.drugi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class Vozac extends Takmicar {
    public Vozac(String ime) {
        super(ime, 1);
    }

    @Override
    public void savladajPrepreku() {
        System.out.printf("Vozac %1$s savladao prepreku!%n", this.ime);
    }

    @Override
    public void prepreka() throws InterruptedException {
        this.oduzmiBodove();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        File eventFile = new File("events.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(eventFile))) {
            writer.newLine();
            writer.write(String.format("Vozac %1$s naletio na prepreku %2$s, pozicija: %3$d%n",
                    this.ime, staza[pozicija], this.pozicija));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
