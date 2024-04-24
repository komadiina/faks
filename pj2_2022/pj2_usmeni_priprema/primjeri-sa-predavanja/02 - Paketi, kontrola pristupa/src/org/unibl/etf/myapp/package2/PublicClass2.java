package org.unibl.etf.myapp.package2;

import org.unibl.etf.myapp.package1.*;

public class PublicClass2 {

	public static void main(String[] args) {
		PublicClass publicClass = new PublicClass();
		PackageClass packageClass = new PackageClass();
//		X x = new X();
	}

}


class PackageClass {

	public void method(){
		System.out.println("Method from PackageClass");
	}
	
}