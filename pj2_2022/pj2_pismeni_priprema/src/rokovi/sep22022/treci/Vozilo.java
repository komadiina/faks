package rokovi.sep22022.treci;

public class Vozilo {
    Integer godina, brojSjedista, snaga;
    Tip tip;
    Boja boja;

    public Vozilo(Integer godina, Integer brojSjedista, Integer snaga, Tip tip, Boja boja) {
        this.godina = godina;
        this.brojSjedista = brojSjedista;
        this.snaga = snaga;
        this.tip = tip;
        this.boja = boja;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (o instanceof Vozilo v)
            return this.godina.equals(v.godina)
                    && this.brojSjedista.equals(v.brojSjedista)
                    && this.tip.equals(v.tip)
                    && this.boja.equals(v.boja)
                    && this.snaga.equals(v.snaga);
        else return false;
    }

    @Override
    public String toString() {
        return String.format("%1$d | %2$d | %3$d | %4$s | %5$s%n",
                godina, snaga, brojSjedista, tip, boja);
    }
}
