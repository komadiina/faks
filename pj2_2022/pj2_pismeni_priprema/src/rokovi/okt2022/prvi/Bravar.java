package rokovi.okt2022.prvi;

public final class Bravar extends Radnik {
    public Bravar(String ime, String prezime, Integer godinaRodjenja) {
        super(ime, prezime, godinaRodjenja);
    }

    @Override
    public boolean obradiPredmet(Predmet p) {
        if (p instanceof Kutija) { // redundantno ali specifikacija je navela tako
            System.out.println("Bravar obradjuje: " + p.id);
            p.obradi();
            ((Kutija<?>)p).otvori();

            return true;
        }

        System.out.println("Bravar ne moze da obradi predmet: " + p.id);
        return false;
    }

    public boolean mozeObraditi(Predmet p) {
        return p instanceof Kutija;
    }
}
