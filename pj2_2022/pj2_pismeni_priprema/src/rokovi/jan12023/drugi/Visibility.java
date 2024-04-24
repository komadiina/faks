package rokovi.jan12023.drugi;

public enum Visibility {
    PRIVATE("private"),
    PROTECTED("protected"),
    PUBLIC("public");

    public final String text;
    Visibility(String text) { this.text = text; }

    @Override
    public String toString() { return this.text; }
}
