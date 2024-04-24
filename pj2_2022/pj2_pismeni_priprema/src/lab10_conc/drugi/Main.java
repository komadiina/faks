package lab10_conc.drugi;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Object[][] staza = new Object[3][15];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 15; j++) {
                staza[i][j] = "[]";
            }

        Random rng = new Random();
        for (int i = 0; i < 3; i++) {
            int X = 4;
            while (X-- > 0)
                staza[i][1 + rng.nextInt(14)] = "STOP";
        }

        Automobil a1 = new Automobil("alfa"),
                a2 = new Automobil("pezo"),
                a3 = new Automobil("opel");

        a1.staza = staza[0];
        a2.staza = staza[1];
        a3.staza = staza[2];

        for (int i = 0; i < 15; i++) {
            System.out.printf("%1$s ", a1.staza[i]);
        }
        System.out.println();

        staza[0][0] = a1;
        staza[1][0] = a2;
        staza[2][0] = a3;

        a1.start(); a2.start(); a3.start();

        try {
            a1.join();
            a2.join();
            a3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            return;
        }

        System.out.printf("Pobjednik: [%1$s]%n", Automobil.pobjednik.tip);
    }
}
