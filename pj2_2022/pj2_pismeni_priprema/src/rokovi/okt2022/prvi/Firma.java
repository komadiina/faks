package rokovi.okt2022.prvi;

import java.util.*;
import java.util.function.*;

public class Firma extends Thread {
    public static boolean alarm = false;
    public static final Object alarmLock = new Object();
    public static List<Radnik> radnici = new ArrayList<>();
    public static List<Predmet> skladiste = new ArrayList<>();
    public static final Object skladisteLock = new Object();
    public static boolean skladisteZauzeto = false;
    public static Queue<Predmet> traka = new ArrayDeque<>();
    public static final Object trakaLock = new Object();
    public static Integer brojObradjenih = 0, brojPredmeta = 0;


    public static synchronized boolean sveObradjeno() {
        return brojObradjenih >= brojPredmeta;
    }

    @Override
    public void run() {
        brojPredmeta = skladiste.size();

        System.out.printf("O: %1$d | N: %2$d%n", brojObradjenih, brojPredmeta);

        for (Radnik r : radnici)
            r.start();

        try {
            for (Radnik r : radnici) {
                r.join();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
