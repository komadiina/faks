package rokovi.okt2022.prvi;

public abstract class Radnik extends Thread {
    public String ime, prezime;
    Integer godinaRodjenja;

    public Radnik(String ime, String prezime, Integer godinaRodjenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.godinaRodjenja = godinaRodjenja;
    }

    public abstract boolean obradiPredmet(Predmet p);

    public void provjeriAlarm() {
        if (Firma.alarm) {
            try {
                synchronized (Firma.alarmLock) {
                    Firma.alarmLock.wait();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Redefinisana za vozace, za varioce i bravare je homogena
    @Override
    public void run() {
        while (!Firma.sveObradjeno()) {
            Predmet p = pridobijPredmet();

            if (p != null) {
                obradiPredmet(p);
                zavrsiObradu(p);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            provjeriAlarm();
        }

        System.out.println("Radnik: " + ime + " " + prezime + " zavrsio sa radom.");
    }

    public synchronized Predmet pridobijPredmet() {
        synchronized (Firma.trakaLock) {
            for (Predmet p : Firma.traka)
                if (!p.obradjen && mozeObraditi(p))
                    return p;

            return null;
        }
    }

    public abstract boolean mozeObraditi(Predmet p);

    public synchronized void zavrsiObradu(Predmet p) {
        Firma.traka.remove(p);

        synchronized (Firma.skladisteLock) {
            if (Firma.skladisteZauzeto)
                try {
                    Firma.skladisteLock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            Firma.skladisteZauzeto = true;
            Firma.skladiste.add(p);
            Firma.skladisteZauzeto = false;
            Firma.skladisteLock.notify();
            Firma.brojObradjenih++;
        }
    }
}
