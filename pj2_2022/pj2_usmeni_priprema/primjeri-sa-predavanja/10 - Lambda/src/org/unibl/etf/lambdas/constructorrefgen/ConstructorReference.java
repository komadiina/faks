package org.unibl.etf.lambdas.constructorrefgen;

public class ConstructorReference {
	public static void main(String[] args) {
		Function<Integer> f = Temperature<Integer>::new;	// 1
		Temperature<Integer> temp = f.function(30);			// 2
		System.out.println(temp.getValue());
	}
}
class Temperature<T> {											// 3
	T value;
	public Temperature() {
		value = null;
	}	
	public Temperature(T temp){
		value = temp;
	}
	public T getValue() {
		return value;
	}
}
interface Function<T> {											// 4
	Temperature<T> function(T t);
}


