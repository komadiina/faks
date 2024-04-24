package org.unibl.etf.clonemethod2;

public class Headphones implements Cloneable {
	private String manufacturer;

	public Headphones(String manufacturer) {
		super();
		this.manufacturer = manufacturer;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Headphones headphones = new Headphones("Sony");
		Headphones headphonesClone = (Headphones) headphones.clone();
		System.out.println(headphones.getManufacturer());
		System.out.println(headphonesClone.getManufacturer());
		System.out.println("===================");
		headphones.setManufacturer("Samsung");
		System.out.println(headphones.getManufacturer());
		System.out.println(headphonesClone.getManufacturer());
	}
}
