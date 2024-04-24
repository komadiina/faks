package org.unibl.etf.nio;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class ChannelCopy {
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) throws Exception {
		String from, to;
		if (args.length != 2) {
			from = "data.txt";
			to = "dataCopy.txt";
		} else {
			from = args[0];
			to = args[1];
		}
		FileInputStream fis = new FileInputStream(from);
		FileOutputStream fos = new FileOutputStream(to);
		FileChannel in = fis.getChannel(), out = fos.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
		while (in.read(buffer) != -1) {
			System.out.println("procitao: " + buffer.position());
			System.out.println("flip...");
			buffer.flip(); // pripremi za pisanje
			out.write(buffer);
			System.out.println("clear...");
			buffer.clear(); // pripremi za citanje
		}
		fis.close();
		fos.close();
	}
}