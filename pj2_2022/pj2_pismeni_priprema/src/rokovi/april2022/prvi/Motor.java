package rokovi.april2022.prvi;

public enum Motor {
    DIZEL("DIZEL"),
    BENZIN("BENZIN"),
    ELEKTRICNI("ELEKTRICNI"),
    HIBRID("HIBRID");

    public final String tipMotora;
    Motor(String tipMotora) {
        this.tipMotora = tipMotora;
    }
}
