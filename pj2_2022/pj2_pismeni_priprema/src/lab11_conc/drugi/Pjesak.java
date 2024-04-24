package lab11_conc.drugi;

import lab11_conc.prvi.SavladajVodu;

public final class Pjesak extends Takmicar implements SavladajVodu, SavladajKamen {
    public Pjesak(String ime) {
        super(ime, 1);
    }

    @Override
    public void savladajPrepreku() {
        System.out.printf("Pjesak %1$s savladao prepreku.%n", this.ime);
    }

    @Override
    public void prepreka() throws InterruptedException {
        this.oduzmiBodove();
        Thread.sleep(4000);
    }
}
