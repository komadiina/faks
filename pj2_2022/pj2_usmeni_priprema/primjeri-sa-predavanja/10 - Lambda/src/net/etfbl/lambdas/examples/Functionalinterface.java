package net.etfbl.lambdas.examples;

@FunctionalInterface
public interface Functionalinterface {

	void print(String name);
	
    @Override
	String toString();
    @Override
	public abstract boolean equals(Object o);
    @Override
    int hashCode();
}

@FunctionalInterface
interface SubFunctionalInterface extends Functionalinterface{
	default void test() {};
}