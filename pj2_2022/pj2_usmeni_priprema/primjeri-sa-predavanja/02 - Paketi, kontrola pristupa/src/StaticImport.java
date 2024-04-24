//import static java.lang.Math.random;

public class StaticImport {
	public static void main(String[] args) {
		double rand = Math.random();
		double rand2 = random();
		System.out.println(rand);
		System.out.println(rand2);
	}

	private static double random() {
		return 0;
	}
}
