public class Proizvod {
	public String name;
	public Double cijena;
	public Kategorija kategorija;

	public Proizvod(String name, Double cijena, Kategorija kategorija) {
		this.name = name;
		this.cijena = cijena;
		this.kategorija = kategorija;
	}

	@Override
	public String toString() {
		return String.format("Proizvod: %1$s | Cijena: %2$.2f | Kategorija: %3$s",
			this.name, this.cijena, this.kategorija);
	}
}