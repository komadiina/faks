package test;

import java.io.*;

public class E implements Externalizable {
	public E() { System.out.println("E::ctor"); }

	public void writeExternal(OutputStream out) {
		System.out.println("E::wExt");	
	}

	public E readExternal(InputStream in) {
		System.out.println("E::rExt");
	}
}