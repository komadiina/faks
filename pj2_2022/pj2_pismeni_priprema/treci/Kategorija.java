import java.util.*;

public class Kategorija {
	public String ime;
	public List<Kategorija> potkategorije;

	public Kategorija(String ime, List<Kategorija> potkategorije) {
		this.ime = ime; this.potkategorije = potkategorije;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o instanceof Kategorija k)
			return k.ime.equals(this.ime);
		return false;		
	}

	@Override
	public String toString() {
		return String.format("Ime kategorije: %1$s, potkategorije: %2$s",
			this.ime, this.potkategorije);
	}
}