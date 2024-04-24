package org.unibl.etf.strings;

public class StringBufferTest {
	public static void main(String[] args) {
		StringBuffer stringBuffer = new StringBuffer();
		System.out.println(stringBuffer.capacity());
		
		StringBuilder stringBuilder = new StringBuilder();
		System.out.println(stringBuilder.capacity());
		
		for(int i=1; i<1_001; i++) {
			stringBuffer.append('a');
			stringBuilder.append('a');
			System.out.println(stringBuffer.capacity());
			System.out.println(stringBuilder.capacity());
			System.out.println("=====");
		}
	}
}
