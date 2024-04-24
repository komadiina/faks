package org.unibl.etf.exceptions;

import java.io.IOException;
import java.sql.SQLException;

public class MultiCatchTest {

	public static void main(String[] args) {
		int x = 10, y = 0;
		int array[] = new int[10];
		try {
			int z = x / y;
			array[11] = 11;
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace(System.out);
		}

	}

}

class MultiCatchTest2 {
	public static void main(String[] args) {
		boolean x = true;
		try{
			if(x){
				throw new Test1Exception();
			}
			throw new Test2Exception();
		}catch(Test1Exception | Test2Exception e){
			e.printStackTrace();
		}
	}
}

class Test1Exception extends Exception{
	
}

class Test2Exception extends Exception{
	
}