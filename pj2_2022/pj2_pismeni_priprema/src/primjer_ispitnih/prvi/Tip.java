package primjer_ispitnih.prvi;

public enum Tip {
    NARUDZBENICA("Narudzbenica"),
    NARUDZBENICA_STAVKA("NarudzbenicaStavka"),
    FAKTURA("Faktura"),
    FAKTURA_STAVKA("FakturaStavka");

    public final String message;
    Tip(String message) {
        this.message = message;
    }
}
