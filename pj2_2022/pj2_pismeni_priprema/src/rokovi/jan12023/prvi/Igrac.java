package rokovi.jan12023.prvi;

public abstract class Igrac {
    private static Integer ID = 0;
    public Integer redniBroj = ++ID;

    public abstract boolean baciKuglu();
}
