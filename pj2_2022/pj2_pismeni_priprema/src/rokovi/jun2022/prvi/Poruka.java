package rokovi.jun2022.prvi;

public final class Poruka {
    public String mbPosiljaoca,
            mbPrimaoca,
            vrijemeSlanja,
            tekstPoruke;

    public Poruka(String mbPosiljaoca, String mbPrimaoca, String vrijemeSlanja, String tekstPoruke) {
        this.mbPosiljaoca = mbPosiljaoca;
        this.mbPrimaoca = mbPrimaoca;
        this.vrijemeSlanja = vrijemeSlanja;
        this.tekstPoruke = tekstPoruke;
    }

    public void izmijeniTekst(String noviTekst) {
        this.tekstPoruke = tekstPoruke;
    }

    @Override
    public String toString() {
        return String.format(
                "Od: %1$s%nZa: %2$s%nVrijeme: %3$s%nPoruka:%4$s%n",
                this.mbPosiljaoca, this.mbPrimaoca,
                this.vrijemeSlanja, this.tekstPoruke
        );
    }
}
