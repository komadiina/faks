package lab11_conc.prvi;

public final class Plivac extends Osoba implements SavladajVodu {
    public Plivac(String ime, String visina, String oprema) {
        super(ime, visina, oprema);
    }

    protected void savladajPrepreku() {
        System.out.printf("[%1$s] Savladana prepreka - %2$s!%n", this.ime, this.staza[pos]);
        this.staza[pos] = null;
    }
}
