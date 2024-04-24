package rokovi.okt2022.prvi;

public final class Varioc extends Radnik {
    public Varioc(String ime, String prezime, Integer godinaRodjenja) {
        super(ime, prezime, godinaRodjenja);
    }

    @Override
    public boolean obradiPredmet(Predmet p) {
        if (p instanceof Ploca || p instanceof Kutija) {
            System.out.println("Varioc obradjuje: "  + p.id);
            p.obradi();

            return true;
        }

        System.out.println("Varioc ne moze da obradi predmet: " + p.id);
        return false;
    }

    @Override
    public boolean mozeObraditi(Predmet p) {
        return p instanceof Ploca || p instanceof Kutija;
    }
}
