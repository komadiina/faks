package org.unibl.etf.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStream2 {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("google3.png");
			FileInputStream fis = new FileInputStream("google.png");
			byte b[] = fis.readAllBytes();
			fos.write(b,0,b.length);
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
