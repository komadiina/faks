package rokovi.jun2022.prvi;

import java.util.*;

public final class PorukeBuffer {
    public static Queue<Poruka> poruke = new ArrayDeque<>();
    public static HashMap<Radnik, List<Poruka>> porukeRadnika = new HashMap<>();
    public static final Object porukaStigla = new Object();
    public static final Object porukaPoslana = new Object();

    public synchronized static void bufferujPoruku(Poruka poruka) {
        poruke.add(poruka);

        // obavijesti prepravljaca/e
        synchronized (porukaStigla)
        {
            porukaStigla.notifyAll();
        }
    }
}
