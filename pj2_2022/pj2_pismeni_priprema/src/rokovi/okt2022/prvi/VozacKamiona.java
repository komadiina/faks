package rokovi.okt2022.prvi;

public final class VozacKamiona extends Vozac {
    public VozacKamiona(String ime, String prezime, Integer godinaRodjenja) {
        super(ime, prezime, godinaRodjenja);
    }

    // ne razlikuje se od specifikacije klase vozaca -> nema nikakve drugacije implementacije
    // sam po sebi je genericki implementacioni detalj
}
