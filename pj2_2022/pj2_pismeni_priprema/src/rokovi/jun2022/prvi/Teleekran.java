package rokovi.jun2022.prvi;

public final class Teleekran extends Thread {
    @Override
    public void run() {
        while (BigBrother.running) {
            synchronized (PorukeBuffer.porukaStigla) {
                try {
                    PorukeBuffer.porukaStigla.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            prikaziPoruku();
        }
    }

    public void obavijestiNadzornika(Nadzornik nad, Integer brojIzmjena) {

    }

    public synchronized void prikaziPoruku() {
        System.out.println(PorukeBuffer.poruke.poll());
    }
}
