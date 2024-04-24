public class Poruka {
	public String jmbgPosiljaoca, jmbgPrimaoca;
	public String tekst;
	public String vrijemeSlanja;
	
	public Poruka(String jmbgPosiljaoca, String jmbgPrimaoca, String tekst, String vrijemeSlanja) {
		this.jmbgPosiljaoca = jmbgPosiljaoca;
		this.jmbgPrimaoca = jmbgPrimaoca;
		this.tekst = tekst;
		this.vrijemeSlanja = vrijemeSlanja;
	}
	
	@Override
	public String toString() {
		return String.format("[PORUKA] [%1$s -> %2$s]%nSadrzaj: %3$s", jmbgPosiljaoca, jmbgPrimaoca, tekst);
	}
}