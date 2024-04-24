package org.unibl.etf.equalsandhashcodemethods;

public class HashCodeTest {

	public static void main(String[] args) {
		MobilePhone t1 = new MobilePhone("Samsung", "S9");	// 1
		MobilePhone t2 = new MobilePhone("S9", "Samsung");	// 2
		System.out.println(t1.hashCode());	   	// 3
		System.out.println(t2.hashCode());	   	// 3
	}

}

class MobilePhone{
	private String manufacturer;
	private String model;
	
	public MobilePhone(String manufacturer, String model){
		this.manufacturer = manufacturer;
		this.model = model;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof MobilePhone){
			MobilePhone t = (MobilePhone)obj;
			if(manufacturer.equals(t.manufacturer) && model.equals(t.model))
				return true;
		}
		return false;
	}

//	public int hashCode() {
//		int hash = 3;
//		hash = 7 * hash + manufacturer.hashCode();
//		hash = 7 * hash + model.hashCode();
//		return hash;
//	}
//	public int hashCode() {
//		return manufacturer.hashCode() + model.hashCode();
//	}
}