package lab12_streams.drugi;

public final class Osoba {
    public String ime, prezime;
    public Integer godine;
    public Boolean imaKucu, imaAutomobil;

    public Osoba(String ime, String prezime, Integer godine, Boolean imaKucu, Boolean imaAutomobil) {
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.imaKucu = imaKucu;
        this.imaAutomobil = imaAutomobil;
    }

    public boolean imaKucu() {
        return this.imaKucu;
    }

    public boolean imaAutomobil() {
        return this.imaAutomobil;
    }

    public Integer getGodine() {
        return this.godine;
    }

    @Override
    public String toString() {
        return String.format("%1$s %2$s %3$d %4$s%5$s",
                this.ime, this.prezime, this.godine,
                this.imaKucu ? "kuca " : "",
                this.imaAutomobil ? "automobil" : "");
    }
}
