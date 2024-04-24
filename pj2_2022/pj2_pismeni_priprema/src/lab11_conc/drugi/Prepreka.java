package lab11_conc.drugi;

public abstract class Prepreka {
    int jacina;
    public Prepreka(int jacina) {
        this.jacina = jacina;
    }

    @Override
    public String toString() {
        return String.format("%1$d", this.jacina);
    }
}
