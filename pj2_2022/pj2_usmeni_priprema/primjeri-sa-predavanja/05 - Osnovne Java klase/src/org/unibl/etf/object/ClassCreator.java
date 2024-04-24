package org.unibl.etf.object;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ClassCreator {

	  public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{

	    ClassLoader classLoader = ClassCreator.class.getClassLoader();

	    try {
	        Class aClass = classLoader.loadClass("org.unibl.etf.object.Phone");
	        Phone t = (Phone) aClass.getDeclaredConstructor().newInstance();
	        System.out.println(t);
	        Field[] f = t.getClass().getDeclaredFields();
	        for (Field field : f) {
	        	System.out.println(field.getName());
	        }

	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
}