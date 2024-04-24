package lab11_conc.peti;

public class Svjetlo {
    // specificiran wrapper za string klasu

    public static String CRVENO = "CRVENO";
    public static String ZUTO = "ZUTO";
    public static String ZELENO = "ZELENO";

    public String trenutno = Svjetlo.CRVENO;

    public String getNext() {
        if (trenutno.equals(Svjetlo.CRVENO))
            return Svjetlo.ZUTO;

        if (trenutno.equals(Svjetlo.ZUTO))
            return Svjetlo.ZELENO;

        // Svjetlo.ZELENO
        return Svjetlo.CRVENO;
    }
}
