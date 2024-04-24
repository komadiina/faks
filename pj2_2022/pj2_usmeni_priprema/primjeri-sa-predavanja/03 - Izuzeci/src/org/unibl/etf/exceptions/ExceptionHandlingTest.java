package org.unibl.etf.exceptions;

public class ExceptionHandlingTest {
	public static void main(String[] args) {
		System.out.println(method()); // 1
		try { // 2
			System.out.println("try from main...");
			int x = 6 / 0;
		} catch (Exception e) { // 3
			System.out.println("exception from main: " + e.getMessage());
		} finally { // 4
			System.out.println("finally from main");
		}
		System.out.println("end of main..."); // 5
	}

	public static int method() {
		try { // 6
			System.out.println("try from method...");
            return 1; // 7
		} catch (Exception e) { // 8
			e.printStackTrace();
        } finally { // 9
            System.out.println("finally from method...");
            return 3; // 10
        }
	}
}
