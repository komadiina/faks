package rokovi.april2022.prvi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.Queue;

public class Terminal extends Thread {
    private static Integer ID = 0;
    public String id = (++ID).toString();
    public boolean running = true;
    public final Object cekanjeLock = new Object();
    public Vozilo trenutnoVozilo = null;
    public Queue<Vozilo> naCekanju = new ArrayDeque<>(3);
    public Integer prosloPutnika = 0, ukupnoTakse = 0;

    public Terminal() {
    }

    public boolean zauzet() {
        return this.trenutnoVozilo != null;
    }

    public boolean popunjenRed() {
        return this.naCekanju.size() == 3;
    }

    @Override
    public void run() {
        while (running) {
            if (this.trenutnoVozilo == null)
                synchronized (this.cekanjeLock) {
                    try {
                        this.cekanjeLock.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

            if (!running)
                break;

            this.trenutnoVozilo.taksa = naplatiTaksu(trenutnoVozilo);
            this.ukupnoTakse += this.trenutnoVozilo.taksa;
            this.prosloPutnika += this.trenutnoVozilo.brojPutnika;

            try {
                Thread.sleep(vrijemeCekanja(trenutnoVozilo));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            this.report();

            synchronized (this.trenutnoVozilo.cekaObraduLock) {
                this.trenutnoVozilo.cekaObraduLock.notify();
            }

            this.trenutnoVozilo = null;
        }
    }

    public void report() {
        String message = String.format("[%1$s] Vozilo %2$s, taksa: %3$d%n",
                id, trenutnoVozilo.id, trenutnoVozilo.taksa);

        System.out.println(message);

        try {
            File outputFile = new File(this.trenutnoVozilo.id);
            outputFile.delete();
            outputFile.createNewFile();
            Files.write(outputFile.toPath(), message.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Integer naplatiTaksu(Vozilo vozilo) {
        Integer taksa = 0;
        taksa += taksaPoMotoru(vozilo);

        if (vozilo instanceof Autobus at)
            taksa += at.brojPutnika * 20;
        else if (vozilo instanceof Kamion)
            taksa += 500;

        return taksa;
    }

    public static Integer taksaPoMotoru(Vozilo vozilo) {
        if (vozilo.tipMotora.equals(Motor.ELEKTRICNI))
            return 0;
        else if (vozilo.tipMotora.equals(Motor.HIBRID))
            return 50;
        else return 100;
    }

    public static Integer vrijemeCekanja(Vozilo vozilo) {
        if (vozilo instanceof Automobil)
            return 1000;
        else if (vozilo instanceof Autobus)
            return 2000;
        else
            return ((Kamion) vozilo).uPrikolici.size() * 1000;

    }
}
