package org.unibl.etf.io;


import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PBReader {
	public static void main(String[] args) throws IOException{
		String s = "if ( a==b ) {c = 10; }";
		char buff[] = s.toCharArray();
		int ch;
		CharArrayReader car = new CharArrayReader(buff);
		PushbackReader pbr = new PushbackReader(car);
		while ((ch = pbr.read()) != -1) {						// 1
			if (ch == '=') {										// 2
				if ((ch = pbr.read()) == '=') {				// 3
					System.out.print(" equals ");
				} else {
					System.out.print(" assignment ");
					pbr.unread(ch);								// 4
				}
			} else {
				System.out.print((char) ch);
			}
		}
	}
}


