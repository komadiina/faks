package lab11_conc.prvi;

import java.time.temporal.IsoFields;
import java.util.Scanner;

public class Simulation extends Thread {
    public Planinar planinar;
    public Plivac plivac;
    public Vatrogasac vatrogasac;
    public Object[][] mapa;

    public Simulation(Planinar planinar, Plivac plivac, Vatrogasac vatrogasac, Object[][] mapa) {
        this.planinar = planinar;
        this.plivac = plivac;
        this.vatrogasac = vatrogasac;
        this.mapa = mapa;
    }

    @Override
    public void run() {
        // Pokreni heroje
        this.vatrogasac.start();
        this.plivac.start();
        this.planinar.start();


    }
}
