package rokovi.jan12023.prvi;

import java.util.*;

public class BowlingAlley extends Thread {
    public List<Cunj> cunjevi = new ArrayList<>();
    public boolean running = true;
    public final Object lock = new Object();
    public boolean strajk = false;

    @Override
    public void run() {
        while (running) {
            // Svaki igrac pri sutu 'obavjestava'
            try {
                synchronized (this.lock) {
                    this.lock.wait();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            // Ukoliko je strajkovano: pocisti sve
            if (strajk) { this.pokupi(); this.postavi(); }
            // Ukoliko nije: rendom postavka;
            else this.rendomPostavka();
        }
    }

    public void rendomPostavka() {
        long brojCunjeva = Math.round((new Random()).nextDouble(1) * 10 + 1);
        this.pokupi();
        for (int i = 0; i < brojCunjeva; i++)
            this.cunjevi.add(new Cunj());
    }

    public void pokupi() {
        this.cunjevi.clear();
    }

    public void postavi() {
        this.cunjevi.addAll(Arrays.asList(
                new Cunj(), new Cunj(), new Cunj(), new Cunj(),
                new Cunj(), new Cunj(), new Cunj(), new Cunj(),
                new Cunj(), new Cunj(), new Cunj()
        ));
    }
}
