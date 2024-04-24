package org.unibl.etf.exceptions;

public class DefaultExceptionHandlerTest {

	public static void main(String[] args) {
		int x = 10, y = 0;
		int z = divide(x, y);
		System.out.println(z);
	}

	private static int divide(int x, int y) {
		return x / y;
	}
}
