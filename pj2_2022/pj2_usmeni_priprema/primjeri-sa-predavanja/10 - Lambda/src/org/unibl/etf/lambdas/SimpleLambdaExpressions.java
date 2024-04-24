package org.unibl.etf.lambdas;

import java.util.function.DoubleSupplier;

public class SimpleLambdaExpressions {
	public static void main(String[] args) {
		DoubleNumber d1 = () -> 10.20;
		DoubleNumber d2 = () -> Math.random() * 10;
		DoubleNumber2 d3 = (number) -> number * Math.random();
		DoubleSupplier ds = () -> 12.34;
		System.out.println(d1.method());
		System.out.println(d2.method());
		System.out.println(d3.method(2));
		System.out.println(ds.getAsDouble());
	}
}

interface DoubleNumber {
	double method();
}

interface DoubleNumber2 {
	double method(double d);
}