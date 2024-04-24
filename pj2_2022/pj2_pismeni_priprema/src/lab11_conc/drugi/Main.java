package lab11_conc.drugi;

import java.util.*;

public class Main {
    public static int BROJ_BONUSA = 0;
    public static int BROJ_PREPREKA = 0;

    private static Object[] initializeStaza() {
        Object[] staza = new Object[50];
        staza = initializePrepreka(staza, new Kamen());
        staza = initializePrepreka(staza, new Voda());
        staza = initializePrepreka(staza, new Vatra());
        staza = initializeBonus(staza);

        return staza;
    }

    private static Object[] initializePrepreka(Object[] staza, Prepreka prepreka) {
        Random rng = new Random(42);
        for (int i = 0; i < BROJ_PREPREKA; i++) {
            int idx = rng.nextInt(staza.length);
            while (staza[idx] != null)
                idx = rng.nextInt(staza.length);

            staza[idx] = prepreka;
        }

        return staza;
    }

    private static Object[] initializeBonus(Object[] staza) {
        Random rng = new Random(42);

        for (int i = 0; i < BROJ_BONUSA; i++) {
            int idx = rng.nextInt(staza.length);

            while (staza[idx] != null)
                idx = rng.nextInt(staza.length);

            staza[idx] = new Bonus(2 + rng.nextInt(3));
        }

        return staza;
    }

    private static void ispisiStazu(Object[] staza) {
        for (int i = 0; i < staza.length; i++) {
            System.out.printf("%1$s ", staza[i]);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Parse commandline arguments
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--bonus"))
                BROJ_BONUSA = Integer.parseInt(args[i+1]);
            else if (args[i].equals("--prepreka"))
                BROJ_PREPREKA = Integer.parseInt(args[i+1]);
        }

        Object[] staza = initializeStaza();
        ispisiStazu(staza);
        System.out.println(staza.length);

        Takmicar.staza = staza;
        Pilot pilot = new Pilot("pilot");
        Vozac vozac = new Vozac("vozac");
        Pjesak pjesak = new Pjesak("pjesak");

        pilot.start();
        vozac.start();
        pjesak.start();

        try {
            pilot.join();
            vozac.join();
            pjesak.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        List<Takmicar> takmicari = new ArrayList<>(Arrays.asList(pilot, vozac, pjesak));
        Collections.sort(takmicari);
        System.out.println(takmicari.get(0));
    }
}
