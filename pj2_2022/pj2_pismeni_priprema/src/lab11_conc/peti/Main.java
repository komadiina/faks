package lab11_conc.peti;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int DUZINA_STAZE = 20;
    public static int BROJ_NOVCICA = 5;
    public static int BROJ_SEMAFORA = 2;

    private static final Random rng = new Random();

    private static Object[] initializeStaza() {
        Object[] staza = new Object[DUZINA_STAZE];
        staza = initializeNovcici(staza);
        staza = initializeSemafori(staza);

        return staza;
    }

    private static Object[] initializeNovcici(Object[] staza) {
        for (int i = 0; i < BROJ_NOVCICA; i++) {
            int idx = rng.nextInt(DUZINA_STAZE);
            while (staza[idx] != null)
                idx = rng.nextInt(DUZINA_STAZE);

            staza[idx] = new Novcic(1 + rng.nextInt(100));
        }

        return staza;
    }

    private static Object[] initializeSemafori(Object[] staza) {
        for (int i = 0; i < BROJ_SEMAFORA; i++) {
            int idx = rng.nextInt(DUZINA_STAZE);

            while (staza[idx] != null)
                idx = rng.nextInt(DUZINA_STAZE);

            staza[idx] = new Semafor();
        }

        return staza;
    }

    private static void ispisiStazu(Object[] staza) {
        for (int i = 0; i < staza.length; i++)
            if (staza[i] instanceof Semafor sem)
                System.out.printf("%1$s ", sem.trenutno);
            else if (staza[i] instanceof Novcic nov)
                System.out.printf("%1$d ", nov.vrijednost);
            else
                System.out.print("[] ");

        System.out.println();
    }

    private static void pokreniSemafore(Object[] staza) {
        for (int i = 0; i < staza.length; i++)
            if (staza[i] instanceof Semafor sem)
                sem.start();
    }

    private static void zaustaviSemafore(Object[] staza) {
        Semafor.isRunning = false;

        for (int i = 0; i < staza.length; i++)
            if (staza[i] instanceof Semafor sem) {
                try {
                    sem.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
    }

    public static void main(String[] args) {
        Igrac.staza = initializeStaza();
        ispisiStazu(Igrac.staza);

        Igrac i1 = new Igrac("ognjen", 0, 1);
        Igrac i2 = new Igrac("maja", DUZINA_STAZE-1, -1);

        pokreniSemafore(Igrac.staza);

        i1.start();
        i2.start();

        try {
            i1.join();
            i2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        zaustaviSemafore(Igrac.staza);
    }
}
