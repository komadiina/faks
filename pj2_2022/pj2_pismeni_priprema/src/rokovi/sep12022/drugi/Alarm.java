package rokovi.sep12022.drugi;

public final class Alarm extends Element {
    private static Integer ID = 0;
    public Integer id = ++ID;
    public String opis, datum;

    public Alarm(String opis, String datum) {
        this.opis = opis;
        this.datum = datum;
    }

    public void akcija() {
        System.out.println(this.id + " | " + this.opis);
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + id +
                ", opis='" + opis + '\'' +
                ", datum='" + datum + '\'' +
                '}';
    }
}
