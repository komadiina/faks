package lab11_conc.peti;

public final class Semafor extends Thread {
    public final static String CRVENO = "CRVENO";
    public final static String ZUTO = "ZUTO";
    public final static String ZELENO = "ZELENO";

    public static Integer ID = 1;
    public final Integer id = (++ID);
    public String trenutno = Semafor.CRVENO;
    public static volatile boolean isRunning = true;
    public final Object promjenaSvjetla = new Object();

    @Override
    public void run() {
        while (Semafor.isRunning) {
            System.out.printf("Semafor [%1$d]: %2$s.%n", this.id, this.trenutno);

            // Odspavaj predodredjeni vremenski period
            try {
                this.odspavaj();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                break;
            }

            // Presaltaj na sledece svjetlo
            this.saltaj();

            // Obavijesti igrace koji cekaju na svjetlo
            synchronized (this.promjenaSvjetla) {
                this.promjenaSvjetla.notifyAll();
            }
        }
    }

    public void odspavaj() throws InterruptedException {
        if (this.trenutno.equals(Semafor.CRVENO))
            Thread.sleep(1800);
        else if (this.trenutno.equals(Semafor.ZUTO))
            Thread.sleep(700);
        else
            Thread.sleep(1800);
    }

    public void saltaj() {
        if (this.trenutno.equals(Semafor.CRVENO))
            this.trenutno = Semafor.ZUTO;
        else if (this.trenutno.equals(Semafor.ZUTO))
            this.trenutno = Semafor.ZELENO;
        else
            this.trenutno = Semafor.CRVENO;
    }
}
