package lab11_conc.drugi;

public final class Bonus {
    public Integer vrijednost;
    public Bonus(Integer vrijednost) {
        this.vrijednost = vrijednost;
    }

    @Override
    public String toString() {
        return String.format("%1$d", this.vrijednost);
    }
}
