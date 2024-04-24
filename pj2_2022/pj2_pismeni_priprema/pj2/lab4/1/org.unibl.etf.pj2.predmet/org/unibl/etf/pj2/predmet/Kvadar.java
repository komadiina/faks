package org.unibl.etf.pj2.predmet;

import java.util.Scanner;
import org.unibl.etf.pj2.

public class Kvadar extends Predmet {
    protected Double a, b, c;

    Kvadar(Double a, Double b, Double c, Double tezina) {
        super(tezina);
        this.a = a;
        this.b = b;
        this.c = c;
        this.zapremina = zapremina();
    }

    public void print() {
        System.out.println("Kvadar, stranica: " + a + ", " + b + ", " + c);
    }

    public void read() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Unesite stranicu a: ");
        a = scn.nextDouble();

        System.out.println("Unesite stranicu b: ");
        b = scn.nextDouble();

        System.out.println("Unesite stranicu c: ");
        c = scn.nextDouble();

        scn.close();

        this.zapremina = zapremina();
    }

    public Double zapremina() {
        return a * b * c;
    }
}
