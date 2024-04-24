package rokovi.okt2022.prvi;

public final class VozacViljuskara extends Vozac {
    public VozacViljuskara(String ime, String prezime, Integer godinaRodjenja) {
        super(ime, prezime, godinaRodjenja);
    }

    @Override
    public boolean obradiPredmet(Predmet p) {
        if (p instanceof Kutija<?> k) {
            prevezi(k);
            return true;
        }

        System.out.println("Vozac viljuskara ne moze da obradi predmet: " + p.id);
        return false;
    }

    @Override
    public boolean mozePrevesti(Predmet p) {
        return p instanceof Kutija<?>;
    }
}
