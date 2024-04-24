package org.unibl.etf.myapp.package4;

public class Main {

	public static void main(String[] args) {
//		SingletonClass singletonClass = new SingletonClass();
//		SingletonClass singletonClass2 = new SingletonClass();
//		System.out.println(singletonClass.getProperty());
//		System.out.println(singletonClass2.getProperty());
		
		SingletonClass s = SingletonClass.getInstance();
		s.getProperty();
		SingletonClass s2 = SingletonClass.getInstance();
		s2.getProperty();
		SingletonClass s3 = SingletonClass.getInstance();
		s3.getProperty();
		System.out.println(s.getProperty());
		System.out.println(s2.getProperty());
		System.out.println(s3.getProperty());
	}

}
