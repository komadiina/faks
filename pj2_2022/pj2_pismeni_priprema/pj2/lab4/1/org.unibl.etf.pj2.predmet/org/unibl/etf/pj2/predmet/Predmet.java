package org.unibl.etf.pj2.predmet;

import org.unibl.etf.pj2.izuzetak;

public abstract class Predmet {
    protected static Integer stId = 1;
    protected Integer id;
    protected Double tezina;
    protected Double zapremina;

    Predmet(Double tezina) {
        id = stId++;
        this.tezina = tezina;
    }

    public abstract void print();

    public abstract void read();

    public abstract Double zapremina();

    public Double tezina() {
        return zapremina * tezina;
    }

    public static Boolean poredjenje(Predmet a, Predmet b) {
        return a.zapremina == b.zapremina;
    }

    public Integer getId() {
        return this.id;
    }

};