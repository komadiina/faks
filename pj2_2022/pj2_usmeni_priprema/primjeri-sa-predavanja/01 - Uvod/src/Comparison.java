
public class Comparison {

	public static void main(String[] args) {
		if (test1() && test2() && test3()) {
			System.out.println("OK");
		} else {
			System.out.println("NOT OK");
		}
		System.out.println("==========");
		if (test1() || test2() || test3()) {
			System.out.println("OK");
		} else {
			System.out.println("NOT OK");
		}
	}

	private static boolean test1() {
		System.out.println("test1");
		return true;
	}

	private static boolean test2() {
		System.out.println("test2");
		return false;
	}

	private static boolean test3() {
		System.out.println("test3");
		return false;
	}

}
