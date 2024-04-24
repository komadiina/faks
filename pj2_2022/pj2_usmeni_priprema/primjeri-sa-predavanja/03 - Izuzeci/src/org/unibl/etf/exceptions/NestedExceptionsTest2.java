package org.unibl.etf.exceptions;

public class NestedExceptionsTest2 {
	public static void main(String[] args) {
		int argsLength = args.length;
		try {
			System.out.println("test");
//			int x = 10/argsLength;
		} catch (Exception e) {
			System.out.println("catch in outer");
			e.printStackTrace(System.out);
			try {
				int x = 10/argsLength;
			} finally {
				System.out.println("finally in nested try 1 ");
			}
		} finally {
			System.out.println("finally in outer try");
			try {
				int x = 10/argsLength;
			} finally {
				System.out.println("finally in nested try 2");
			}
		}
	}
}
