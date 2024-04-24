package org.unibl.etf.javalangclasses;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// Boolean, Character, Byte, Short, Integer, Long, Float i Double
		Short s = Short.valueOf("1");
		
		System.out.println("====methods====");
		Class clsX = new X().getClass();					// 1
		Method methods[] = clsX.getDeclaredMethods();		// 2
		for (Method method : methods) {
			System.out.println(method.toGenericString());	// 3
		}
		System.out.println("====fields====");
		Field fields[] = clsX.getDeclaredFields();			// 4
		for (Field field : fields) {
			System.out.println(field.toGenericString());	// 5
		}
		System.out.println("====constructors====");
		Constructor c[] = clsX.getDeclaredConstructors();	// 6
		for (Constructor constr : c) {
			System.out.println(constr.toGenericString());	// 7
		}
		
//		Class intClass = int.class;
//		System.out.println(intClass.getCanonicalName());
//		Class stringClass = String.class;
//		System.out.println(stringClass.getCanonicalName());
//		Class intArrayClass = int[][][].class;
//		System.out.println(intArrayClass.getCanonicalName());
	}
}

class X {															// 8
	int a;
	float b;
	private X(int x, int y) {
		
	}
	protected X(float f) {
		
	}
	public X() {

	}
	public X(int a) {

	}
	private void test() {
		
	}
	public void test2() {
		
	}
}
