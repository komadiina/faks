
public class VarArg {

	public static void main(String[] args) {
		abc("1", "2", "3", "3", "3", "3", "3", "3");
	}
	
	public static void abc(String... args) {
		System.out.println("Size: " + args.length);
		for (String string : args) {
			System.out.println(string);
		}
	}

}
