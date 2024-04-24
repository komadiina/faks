package org.unibl.etf.exceptions;

import java.text.ParseException;

public class Parent {
	public void first() throws MyException,          
 						ParseException{ 					// 1
		//...
	}
}
class Child extends Parent{
	public void first() throws ParseException {	   // 2
		//...
	}
}


class MyException extends Exception{

	public MyException(String string) {
		// TODO Auto-generated constructor stub
	}
	
}