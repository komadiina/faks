package rokovi.april2022.prvi;

public abstract class Vozilo extends Thread {
    private static Integer ID = 0;
    public String id = (++ID).toString();
    public Vozac vozac;
    public Integer brojPutnika;
    public Motor tipMotora;
    public Integer taksa = null;
    public final Object cekaTerminalLock = new Object();
    public final Object cekaObraduLock = new Object();
    public Integer pozicija = -1;

    public Vozilo(Vozac vozac, Integer brojPutnika, Motor tipMotora) {
        super();
        this.vozac = vozac;
        this.brojPutnika = brojPutnika;
        this.tipMotora = tipMotora;
    }

    public void setPozicija(Integer pozicija) {
        this.pozicija = pozicija;
    }

    @Override
    public void run() {
        while (this.nijePrviURedu())
            this.napreduj();

        if (this.trebaPrevesti()) {
            Terminal term = this.nadjiSledeciTerminal();
            this.cekajNaTerminal(term);

            term.trenutnoVozilo = this;
            synchronized (term.cekanjeLock) {
                term.cekanjeLock.notify();
            }

            synchronized (this.cekaObraduLock) {
                try {
                    this.cekaObraduLock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        System.out.printf("Zavrsena obrada za [%1$s]!%n", this.id);
    }

    public void cekajNaTerminal(Terminal t) {
        try {
            synchronized (this.cekaTerminalLock) {
                this.cekaTerminalLock.wait();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void napreduj() {
        if (GranicniPrelaz.put[this.pozicija - 1] != null)
            return;

        GranicniPrelaz.put[--this.pozicija] = this;
        GranicniPrelaz.put[this.pozicija + 1] = null;
    }

    public synchronized Terminal nadjiSledeciTerminal() {
        while (true) {
            for (Terminal t : GranicniPrelaz.terminali)
                if (!t.popunjenRed())
                    return t;

            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public synchronized boolean nijePrviURedu() {
        return this.pozicija > 0;
    }

    public abstract boolean trebaPrevesti();
}
