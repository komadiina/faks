package org.unibl.etf.clonemethod;

public class Phone implements Cloneable { 					// 1
	private Headphones headphones; 							// 2
	private String manufacturer;
	private String model;

	public Phone() {
		model = "Default";
		manufacturer = "Default";
		headphones = new Headphones("Default");
	}

	public Phone(String mf, String md, Headphones h) {
		super();
		this.manufacturer = mf;
		this.model = md;
		this.headphones = h;
	}

	public static void main(String[] args) {
		try {
			Headphones sonyHdp = new Headphones("Sony"); 		// 3
			Phone s9 = new Phone("Samsung", "S9", sonyHdp);		// 4
			Phone clone = (Phone) s9.clone(); 					// 5
			s9.print(); 										// 6
			clone.print(); 										// 7
			System.out.println("===================");
			sonyHdp.setManufacturer("Samsung"); 				// 8
			s9.print(); 										// 9
			clone.print(); 										// 10
			System.out.println(s9==clone);
			System.out.println(s9.headphones==clone.headphones);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	private void print() { 										// 11
		System.out.println(manufacturer + " " + model + " " + headphones.getManufacturer());
	}
}

class Headphones {
	private String manufacturer;

	public Headphones(String manufacturer) {
		super();
		this.manufacturer = manufacturer;
	}

	public Headphones() {
		this.manufacturer = "Default";
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
