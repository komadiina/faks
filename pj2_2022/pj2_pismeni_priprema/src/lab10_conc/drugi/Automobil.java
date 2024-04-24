package lab10_conc.drugi;

public final class Automobil extends Thread {
    public static Automobil pobjednik = null;
    public static final Object lock = new Object();

    public String tip, id;
    private static Integer ID = 0;
    private int pos = 0;

    public Object[] staza = null;

    public Automobil(String tip) {
        this.tip = tip;
        this.id = (++ID).toString();
    }

    @Override
    public void run() {
        while (pos < 14) {
            System.out.printf("[%1$s] Pozicija: %2$d%n", this.tip, this.pos);

            synchronized (Automobil.lock) {
                if (Automobil.pobjednik != null)
                    break;
            }

            if (this.staza[pos+1].equals("STOP")) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            pos++;
        }

        synchronized (Automobil.lock) {
            if (Automobil.pobjednik == null)
                Automobil.pobjednik = this;
        }
    }
}
