package org.unibl.etf.clonemethod2;

public class Phone implements Cloneable { //implements Cloneable
	private Headphones headphones;
	private String manufacturer;
	private String model;


	public Phone(String manufacturer, String model, Headphones h) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.headphones = h;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Phone t = (Phone) super.clone();
		t.headphones = (Headphones) headphones.clone();
		return t;
	}
	
	public static void main(String[] args) {
		try {
			Headphones sonyHdp = new Headphones("Sony"); 			// 3
			Phone s9 = new Phone("Samsung", "S9", sonyHdp);			// 4
			Phone clone = (Phone) s9.clone(); 						// 5
			s9.print(); 											// 6
			clone.print(); 											// 7
			sonyHdp.setManufacturer("Samsung"); 					// 8
			System.out.println("===================");
			s9.print(); 											// 9
			clone.print(); 											// 10
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	private void print() { 											// 11
		System.out.println(manufacturer + " " + model + " " + headphones.getManufacturer());
	}
}
