package lab11_conc.prvi;

public final class Vatrogasac extends Osoba implements SavladajVatru, SavladajStijenu {
    public Vatrogasac(String ime, String visina, String oprema) {
        super(ime, visina, oprema);
    }

    protected void savladajPrepreku() {
        System.out.printf("[%1$s] Savladana prepreka - %2$s!%n", this.ime, this.staza[pos]);
        this.staza[pos] = null;
    }
}
