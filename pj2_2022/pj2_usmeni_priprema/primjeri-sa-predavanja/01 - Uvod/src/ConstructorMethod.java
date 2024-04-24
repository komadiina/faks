
public class ConstructorMethod {
	public ConstructorMethod() { // 1
		super();
	}

	public void ConstructorMethod() { // 2
		System.out.println("This is method...");
	}
	
	public static void main(String[] args) {
		ConstructorMethod constructorMethod = new ConstructorMethod();
		constructorMethod.ConstructorMethod();
	}
}