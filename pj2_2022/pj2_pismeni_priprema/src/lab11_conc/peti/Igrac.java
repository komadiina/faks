package lab11_conc.peti;

import jdk.jshell.spi.ExecutionControl;
import lab11_conc.prvi.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class Igrac extends Thread {
    public String ime;
    public List<Novcic> novcici = new ArrayList<>();
    public Integer pozicija, pomjeraj, vrijemeKretanja;
    public Stopwatch stoperica = new Stopwatch();

    public static Object[] staza = null;

    public Igrac(String ime, Integer pozicija, Integer pomjeraj) {
        this.ime = ime;
        this.pozicija = pozicija;
        this.pomjeraj = pomjeraj;
    }

    @Override
    public void run() {
        this.stoperica.setDaemon(true);
        this.stoperica.start();

        // Omoguceno kretanje sa pocetka i kraja
        while (this.pozicija >= 0 && this.pozicija < Igrac.staza.length) {
            System.out.printf("Igrac [%1$s]: Pozicija = %2$d.%n",
                    this.ime, this.pozicija);

            Object trenutnoPolje = Igrac.staza[this.pozicija];

            if (trenutnoPolje instanceof Semafor sem) {
                while (!sem.trenutno.equals(Semafor.ZELENO)) {
                    synchronized (sem.promjenaSvjetla) {
                        try {
                            sem.promjenaSvjetla.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            } else if (trenutnoPolje instanceof Novcic novcic) {
                this.pokupi();
            }

            // Prelazak sa jednog na drugo polje
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                break;
            }

            this.pozicija += pomjeraj;
        }

        // Ovdje je stao
//        Igrac.staza[this.pozicija] = this;

        this.stoperica.enabled = false;
        this.stoperica.interrupt();
        this.vrijemeKretanja = (int) Math.round(this.stoperica.elapsed);

        this.ispisi(); // Vrijeme kretanja, vrijednost novcica
    }

    private void ispisi() {
        System.out.printf("--- Igrac %1$s ---%n", this.ime);
        System.out.printf("- Vrijeme kretanja: %1$d s.%n", this.vrijemeKretanja);
        System.out.printf("- Vrijednost novcica: %1$d%n", this.vrijednost());
    }

    private Integer vrijednost() {
        Integer vrijednost = 0;
        for (Novcic n : this.novcici)
            vrijednost += n.vrijednost;
        return vrijednost;
    }

    public synchronized boolean pokupi() {
        if (Igrac.staza[this.pozicija] == null)
            return false;

        this.novcici.add((Novcic) Igrac.staza[this.pozicija]);
        Igrac.staza[this.pozicija] = null;

        System.out.printf("Igrac [%1$s] je pokupio novcic!%n", this.ime);

        return true;
    }
}
