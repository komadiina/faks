package org.unibl.etf.object;

import java.lang.reflect.Field;

public class PhoneCloneable implements Cloneable {
	private HeadphonesCloneable headphones;
	private String manufacturer;
	private String model;


	public PhoneCloneable(String manufacturer, String model, HeadphonesCloneable h) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.headphones = h;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
//		return super.clone();
		PhoneCloneable t = (PhoneCloneable) super.clone();
		t.headphones = (HeadphonesCloneable) headphones.clone();
		return t;
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		HeadphonesCloneable sony = new HeadphonesCloneable("Sony");
		PhoneCloneable nokiaE72 = new PhoneCloneable("Nokia", "E72", sony);
		PhoneCloneable nokiaE72Clone = (PhoneCloneable) nokiaE72.clone();
		System.out.println("======== Prije izmjene originala =======");
		System.out.println("Original: " + nokiaE72.manufacturer + " " + nokiaE72.model + " " + nokiaE72.headphones.getManufacturer());
		System.out.println("Clone: " + nokiaE72Clone.manufacturer + " " + nokiaE72Clone.model + " " + nokiaE72Clone.headphones.getManufacturer());
		System.out.println("======== headphones hash code =======");
		System.out.println(nokiaE72Clone.headphones.hashCode());
		System.out.println(nokiaE72.headphones.hashCode());
		nokiaE72.setModel("ABC");
		nokiaE72.headphones.setManufacturer("XYZ");
		System.out.println("======== Nakon izmjene originala =======");
		System.out.println("Original: " + nokiaE72.manufacturer + " " + nokiaE72.model + " " + nokiaE72.headphones.getManufacturer());
		System.out.println("Clone: " + nokiaE72Clone.manufacturer + " " + nokiaE72Clone.model + " " + nokiaE72Clone.headphones.getManufacturer());
		System.out.println("======== headphones hash code =======");
		System.out.println(nokiaE72Clone.headphones.hashCode());
		System.out.println(nokiaE72.headphones.hashCode());
		System.out.println("======== class names =======");
		System.out.println(nokiaE72.getClass().getCanonicalName());
		System.out.println(nokiaE72.getClass().getSimpleName());
		Field[] f = nokiaE72.getClass().getDeclaredFields();
		System.out.println("======== declared fields =======");
		for (Field field : f) {
			System.out.println(field.getName());
		}
	}
}
