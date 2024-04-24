package org.unibl.etf.exceptions;

public class NestedExceptionsTest {
	public static void main(String[] args) {
		int argsLength = args.length;
		try {
			try {
				int x = 10/argsLength; 
			} finally {
				System.out.println("finally in nested try");
			}
		} catch (Exception e) {
			System.out.println("catch in outer");
			e.printStackTrace(System.out);
		} finally {
			System.out.println("finally in outer try");
		}
	}
}
