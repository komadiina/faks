public class Predmet implements Serializable {
	private static Integer ID = 1;
	
	public String naziv;
	public Integer id;
	
	public Predmet(String naziv, Integer id) {
		this.id = id;
		this.naziv = naziv;
	}
	
	public Predmet(String naziv, Integer id) { this.naziv = naziv; this.id = id; }
	
	public static Predmet fromString(String str) {
		String[] tokens = str.split(" ");
		
		String naziv = tokens[0];
		Integer id = Integer.parseInt(tokens[1]);
		
		return new Predmet(naziv, id);
	}
}