public class Stanovnik {
    private String punoIme;

    public Integer xPos, yPos;

    Stanovnik(String ime) {
        punoIme = ime;
    }

    public void setIme(String ime) {
        this.punoIme = ime;
    }

    public String getIme() {
        return this.punoIme;
    }
}