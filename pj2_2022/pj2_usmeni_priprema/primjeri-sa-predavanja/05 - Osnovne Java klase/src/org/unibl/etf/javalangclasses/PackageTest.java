package org.unibl.etf.javalangclasses;

import org.unibl.etf.equalsandhashcodemethods.Phone;

public class PackageTest {

	public static void main(String[] args) {
		Package packages[] = Package.getPackages();
		for (Package pckg : packages) {
			System.out.println(pckg.getName());
		}
		System.out.println("================");
		Phone phone = new Phone("abc", "abc");
		packages = Package.getPackages();
		for (Package pckg : packages) {
			System.out.println(pckg.getName());
		}

		System.out.println("================");
		Module module = String.class.getModule();
		System.out.println(module.getName());
	}

}
