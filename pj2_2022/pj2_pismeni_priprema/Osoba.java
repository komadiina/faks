public class Osoba {
    public String ime;
    protected int broj;

    public Osoba() {
    }

    public Osoba(String ime, int broj) {
        this.ime = ime;
        this.broj = broj;
    }

    public getime() {
        return this.ime;
    }

    public setime(String ime) {
        this.ime = ime;
    }

    public getbroj() {
        return this.broj;
    }

    public setbroj(int broj) {
        this.broj = broj;
    }

    public void testMetoda(String ime) {
    }

    @Override
    public String toString() {
        return String.format("ime, broj, ");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof Osoba p) {
            return this.ime == p.ime && this.broj == p.broj;
        }
        return false;
    }
}
