package lab11_conc.drugi;

import lab11_conc.prvi.SavladajVatru;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.Random;

public abstract class Takmicar extends Thread implements Comparable<Takmicar> {
    public String ime;
    public Integer pomjeraj;
    public Integer brojPoena = 0;
    public Integer pozicija = 0;
    public static Object[] staza;

    public Takmicar(String ime, Integer pomjeraj) {
        this.ime = ime;
        this.pomjeraj = pomjeraj;
    }

    @Override
    public void run() {
        Random rng = new Random();
        System.out.println("Takmicar: " + this.ime);

        while (this.pozicija < staza.length) {
            System.out.printf("%1$s na poziciji: %2$d%n", this.ime, this.pozicija);

            if (staza[this.pozicija] != null) {
                if (staza[this.pozicija] instanceof Bonus)
                    this.pokupi();
                else if (staza[this.pozicija] instanceof Prepreka)
                    if (!this.mozeSavladati())
                        try {
                            this.prepreka();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    else this.savladajPrepreku();
            }

            int brzina = 1000 + rng.nextInt(1000);
            try {
                Thread.sleep(brzina);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            this.pozicija += this.pomjeraj;
        }

        System.out.printf("[!!] Takmicar %1$s zavrsio trku!%n", this.ime);
    }

    private boolean mozeSavladati() {
        if (staza[this.pozicija] == null)
            return true;

        Prepreka trenutno = (Prepreka) staza[this.pozicija];
        return (trenutno instanceof Vatra && this instanceof SavladajVatru)
                || (trenutno instanceof Voda && this instanceof SavladajVodu)
                || (trenutno instanceof Kamen && this instanceof SavladajKamen);
    }

    private synchronized void pokupi() {
        // Ako metoda ceka na monitor dok je u medjuvremenu druga nit pokupila bonus
        if (staza[this.pozicija] == null)
            return;

        this.brojPoena += ((Bonus) (staza[this.pozicija])).vrijednost;
        staza[this.pozicija] = null;
    }

    public abstract void savladajPrepreku();

    protected void oduzmiBodove() {
        this.brojPoena -= ((Prepreka) staza[this.pozicija]).jacina;
    }

    public abstract void prepreka() throws InterruptedException;

    @Override
    public int compareTo(Takmicar t) {
        return Integer.compare(t.brojPoena, this.brojPoena);
    }

    @Override
    public String toString() {
        return String.format("%1$s - [%2$d]%n", this.ime, this.brojPoena);
    }
}
