package org.unibl.etf.equalsandhashcodemethods;

public class ToString {

	public static void main(String[] args) {
		Phone t1 = new Phone("Samsung", "S9");
		String s = "string   " + t1;
		System.out.println(s);
		Class<? extends Phone> c = t1.getClass();
		System.out.println(c.getCanonicalName());
		System.out.println(Integer.toHexString(t1.hashCode()));
		System.out.println("===========");
		MobPhone mobPhone = new MobPhone("Samsung", "S20");
		System.out.println(mobPhone);
	}

}


class MobPhone extends Phone {

	public MobPhone(String manufacturer, String model) {
		super(manufacturer, model);
	}
	
	@Override
	public String toString() {
		String retVal = "Manufacturer: " + manufacturer + "\n" +
				"Model: " + model;
		return retVal;
	}
}