package org.unibl.etf.pj2.predmet;

import java.lang.Math;
import java.util.Scanner;

public class Sfera extends Predmet {
    protected Double poluprecnik;

    Sfera(Double poluprecnik, Double tezina) {
        super(tezina); // ?
        this.poluprecnik = poluprecnik;
        this.zapremina = zapremina();
    }

    public Double zapremina() {
        return (4.0 / 3.0) * Math.PI * Math.pow(poluprecnik, 3.0);
    }

    public void print() {
        System.out.println("Sfera: r = " + poluprecnik + ", zapremina: " + zapremina);
    }

    public void read() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Unesite p.p. sfere: ");
        this.poluprecnik = scn.nextDouble();

        scn.close();

        this.zapremina = zapremina();
    }
}
