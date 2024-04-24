package org.unibl.etf.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;

public class CheckedIOStream {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("etf2.jpg");
		FileInputStream fis = new FileInputStream("etf.jpg");
		CheckedInputStream cis = new CheckedInputStream(fis, new CRC32());
		BufferedInputStream bis = new BufferedInputStream(cis);
		CheckedOutputStream cos = new CheckedOutputStream(fos, new CRC32());
		BufferedOutputStream bos = new BufferedOutputStream(cos);
		byte b[] = new byte[1024];
		int l;
		int totalBytes = 0;
		while((l=bis.read(b))!=-1) {
			System.out.println("Procitano " + l + " bajta");
			totalBytes += l;
			bos.write(b,0,l);
		}
//		bos.write(1);
		bos.flush();
		System.out.println("Ukupno bajta: " + totalBytes);
		System.out.println(cis.getChecksum().getValue());
		System.out.println(cos.getChecksum().getValue());
		fos.close();
		fis.close();
		
	}

}
