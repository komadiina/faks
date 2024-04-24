package org.unibl.etf.exceptions;

import java.util.Scanner;

public class IllegalStateExceptionTest {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		keyboard.close();
		keyboard.hasNext();
	}
}


class IllegalStateExceptionTest2 {
	public static void main(String[] args) {
		subroutine();
	}
	
	private static void subroutine() {
		Scanner keyboard = new Scanner(System.in);
		keyboard.close();
		keyboard.hasNext();
	}
} 