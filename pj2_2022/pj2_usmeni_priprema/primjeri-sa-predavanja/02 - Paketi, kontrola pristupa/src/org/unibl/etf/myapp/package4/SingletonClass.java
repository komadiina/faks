package org.unibl.etf.myapp.package4;

public class SingletonClass {
	private static SingletonClass instance;
	private String property;
	
	private SingletonClass() {
		property = "String " + Math.random();
		System.out.println("Constructor SingletonClass");
	}
	
	public static SingletonClass getInstance() {
		if(instance==null) {
			instance = new SingletonClass();
		}
		return instance;
	}

	public String getProperty() {
		return property;
	}

}
