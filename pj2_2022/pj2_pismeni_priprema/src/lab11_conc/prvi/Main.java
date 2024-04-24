package lab11_conc.prvi;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Object[][] initializePrepreka(Object[][] mapa, String prepreka, Integer broj) {
        Random rng = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < broj; j++) {
                int idx = 1 + rng.nextInt(19);
                while (mapa[i][idx] != null) {
                    idx = 1 + rng.nextInt(19);
                }

                mapa[i][idx] = prepreka;
            }
        }

        return mapa;
    }

    public static void main(String[] args) {
        Object[][] mapa = new Object[3][20];
//        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < 20; j++)
//                mapa[i][j] = " . ";

        mapa = initializePrepreka(mapa, "STIJENA", 4);
        mapa = initializePrepreka(mapa, "VODA", 4);
        mapa = initializePrepreka(mapa, "VATRA", 4);

        Planinar planinar = new Planinar("planinar", "1.80m", "ruke");
        Plivac plivac = new Plivac("plivac", "1.77m", "gilje");
        Vatrogasac vatrogasac = new Vatrogasac("vatrogasac", "1.92m", "protivpozarni aparat");

        planinar.staza = mapa[0];
        plivac.staza = mapa[1];
        vatrogasac.staza = mapa[2];

        planinar.start();
        plivac.start();
        vatrogasac.start();
//        Scanner scn = new Scanner(System.in);
//        opcija = scn.nextLine();
//
//        while (!opcija.equals("KRAJ")) {
//            opcija = scn.nextLine();
//            System.out.println("[SIM] Vasa opcija: " + opcija);
//
//            if (opcija.equals("PAUZA")) {
//                Osoba.pauzirano = true;
//                System.out.println("[SIM] Pauzirana simulacija...");
//            } else if (opcija.equals("NASTAVI")) {
//                Osoba.pauzirano = false;
//                synchronized (Osoba.lock) {
//                    Osoba.lock.notifyAll();
//                }
//
//                System.out.println("[SIM] Nastavljanje simulacije...");
//            }
//        }
        String opcija;
//

        try {
            planinar.join();
            vatrogasac.join();
            plivac.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        ispisiMapu(mapa);
    }

    private static void ispisiMapu(Object[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++)
                if (mapa[i][j] != null)
                    System.out.printf("%1$s ", mapa[i]);
                else System.out.print("[ ] ");

            System.out.println();
        }
    }
}
