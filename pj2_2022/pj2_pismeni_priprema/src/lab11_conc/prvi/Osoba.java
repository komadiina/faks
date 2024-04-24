package lab11_conc.prvi;

import java.util.Timer;

public abstract class Osoba extends Thread {
    public static Boolean pauzirano = false;
    public static final Object lock = new Object();
    public String ime, visina, oprema;
    public Stopwatch stoperica = new Stopwatch();
    public Object[] staza = null;
    public Integer pos = 0;

    public Osoba(String ime, String visina, String oprema) {
        this.ime = ime;
        this.visina = visina;
        this.oprema = oprema;
    }

    @Override
    public void run() {
        this.stoperica.start();

        while (this.pos < staza.length) {
            System.out.printf("[%1$s] Pozicija -> %2$d%n", this.ime, this.pos);

            // Ako je prepreka (ako nije == null)
            if (this.staza[pos] != null) {
                if ((this.staza[pos].equals("STIJENA") && !(this instanceof SavladajStijenu))
                        || (this.staza[pos].equals("VODA") && !(this instanceof SavladajVodu))
                        || (this.staza[pos].equals("VATRA") && !(this instanceof SavladajVatru)))
                    try {
                        System.out.printf("[%1$s] Nesavladiva prepreka: %2$s...%n", this.ime, this.staza[pos]);
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                else {
                    this.savladajPrepreku();
                }
            }

            if (this.staza[this.pos] == null)
                this.staza[this.pos] = this;

            if (pos > 0)
                if (this.staza[pos - 1] == this)
                    this.staza[pos - 1] = null;

            this.pos++;


            // Provjera pauze
            synchronized (Osoba.lock) {
                if (Osoba.pauzirano) {
                    Stopwatch.paused = true;

                    try {
                        Osoba.lock.wait(); // notifyAll
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            }
        }

        System.out.printf("[%1$s] GOTOV!%n", this.ime);
    }

    protected abstract void savladajPrepreku();
}
