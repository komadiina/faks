public abstract class Stanovnik extends Thread {
	public String ime, prezime, jmbg;
	
	public Stanovnik() { ime = ""; prezime = ""; jmbg = ""; }
	public Stanovnik(String ime, String prezime, String jmbg) {
		this.ime = ime; this.prezime = prezime; this.jmbg = jmbg;
	}
	
	@Override
	public String toString() {
		return String.format("%1$s %2$s [%3$s]", ime, prezime, jmbg);
	}
}