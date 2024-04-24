package org.unibl.etf.clientapp;

import org.unibl.etf.myapp.HelloWorld;
import org.unibl.etf.myapp.extended.HelloWorldExtended;

public class HelloWorldClient {
	public static void main(String arg[]) {
		HelloWorld hello = new HelloWorld();
		System.out.println(hello.sayHelloWorld());
		HelloWorldExtended helloAdv = new HelloWorldExtended();
		System.out.println(helloAdv.sayHello("Extended"));
	}
}
