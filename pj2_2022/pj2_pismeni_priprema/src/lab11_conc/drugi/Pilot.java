package lab11_conc.drugi;

import lab11_conc.prvi.SavladajVatru;

public final class Pilot extends Takmicar implements SavladajVatru, SavladajKamen
{
    public Pilot(String ime) {
        super(ime, 2);
    }

    @Override
    public void savladajPrepreku() {
        System.out.printf("Pilot %1$s savladao prepreku.%n", this.ime);
    }

    @Override
    public void prepreka() throws InterruptedException {
        this.oduzmiBodove();
        Thread.sleep(5000);
    }
}
