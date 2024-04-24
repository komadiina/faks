package net.etfbl.generics;

public class GenericNumberHolder<T extends Number> extends GenericHolder<T> {

	public static void main(String[] args) {
//		GenericNumberHolder<String> integerHolder = new GenericNumberHolder<String>();
		GenericNumberHolder<Number> integerHolder = new GenericNumberHolder<Number>();
		integerHolder.set(10);
		System.out.println(integerHolder.print());
//		integerHolder.set("10");
		Number otherInteger = integerHolder.get();
		System.out.println(otherInteger);
	}
}