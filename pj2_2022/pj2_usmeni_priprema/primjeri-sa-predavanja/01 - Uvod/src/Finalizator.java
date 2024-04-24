
public class Finalizator {

	public static void main(String[] args) {
		A a = new A();
		a = null;
		System.gc();
	}

}


class A {
	static {
		System.out.println("Static init blok");
	}
	
	{
		System.out.println("Non-static init blok");
	}
	
	{
		System.out.println("Non-static init blok 2");
	}
	
	public A() {
		System.out.println("Constructor A");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize");
	}
	
	
}