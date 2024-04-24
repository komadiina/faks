import java.io.IOException;

class ClassB {
	static {
		System.out.println("ClassB staticki inicijalizacioni blok");
	}
	{
		System.out.println("ClassB nestaticki inicijalizacioni blok");
	}

	public ClassB() {
		System.out.println("ClassB konstruktor...");
	}

	public void method() {
		System.out.println("ClassB metoda...");
	}

	protected void finalize() throws Throwable {
		System.out.println("ClassB finalize");
	}
}

public class ClassA {
	private double array[] = new double[100_000_000];
	private ClassB classBInstance = new ClassB();
	private int i;
	private float f;
    private String s;
    
    {
        System.out.println("ClassA nestaticki inicijalizacioni blok 1");
    }
	
    static {
		System.out.println("ClassA staticki inicijalizacioni blok");
	}

    {
        System.out.println("ClassA nestaticki inicijalizacioni blok 2");
    }
	
    static {
        System.out.println("ClassA staticki inicijalizacioni blok 2");
    }

	ClassA() {
		super();
		System.out.println("nakon super");
		classBInstance.method();
		System.out.println("ClassA konstruktor");
	}

	protected void finalize() throws Throwable {
		System.out.println("ClassA finalize");
	}

	public static void main(String args[]) throws IOException {
		ClassA a = new ClassA();
		a = null;
//		System.in.read();
		System.gc();
		System.in.read();
		System.out.println("main");
//		System.in.read();
		// ClassA a2 = new ClassA();
		// System.in.read();
		// new ClassB();
	}

}