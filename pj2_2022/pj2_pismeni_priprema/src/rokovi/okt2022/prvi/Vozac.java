package rokovi.okt2022.prvi;

public abstract class Vozac extends Radnik {
    public Vozac(String ime, String prezime, Integer godinaRodjenja) {
        super(ime, prezime, godinaRodjenja);
    }

    @Override
    public boolean obradiPredmet(Predmet p) {
        prevezi(p);
        return true;
    }

    @Override
    public void run() {
        while (!Firma.sveObradjeno()) {
            Predmet p = pridobijPredmet();

            if (p != null) {
                Firma.skladiste.remove(p);
                prevezi(p);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            provjeriAlarm();
        }

        System.out.printf("Vozac: %1$s %2$s zavrsio sa radom.%n",
                ime, prezime);
    }

    public synchronized Predmet pridobijPredmet() {
        Predmet target = null;

        synchronized (Firma.skladisteLock) {
            if (Firma.skladisteZauzeto)
                try {
                    Firma.skladisteLock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            Firma.skladisteZauzeto = true;
            for (Predmet p : Firma.skladiste)
                if (!p.obradjen && this.mozePrevesti(p)) {
                    target = p;
                    break;
                }

            if (target != null)
                Firma.skladiste.remove(target);

            Firma.skladisteZauzeto = false;
            Firma.skladisteLock.notify();
        }

        return target;
    }

    public boolean mozePrevesti(Predmet p) {
        return true;
    }

    public void prevezi(Predmet p) {
        System.out.println("Vozac prevozi predmet: " + p.id + ", obradjen= " + p.obradjen);
        Firma.traka.add(p);
    }

    public boolean mozeObraditi(Predmet p) {
        return true;
    }
}
