package net.etfbl.lambdas.strings;

public class StringComparator {
	private String s;
	
	public StringComparator(String s) {
		System.out.println("StringComparator konstruktor: " + s);
		this.s = s;
	}
	
	public boolean sameLength(StringComparator s2) {
		System.out.println("tekuci objekat je: " + s);
		System.out.println("argument je: " + s2.s);
		return s.length()==s2.s.length();
	}
	
	public boolean isLongerThen(StringComparator s2) {
		return s.length() > s2.s.length();
	}
}
