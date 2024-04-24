
public class Loops {
	public static void main(String[] args) {
		for (int i = 0, j = 0; i < 10 && j != 11; i++, j++) {
			System.out.println(i + "  " + j);
		}
		for (int i = 0; i < 100; i++) {
			// izlaz iz for petlje
			if (i == 74)
				break;
			// sljedeća iteracija
			if (i % 9 != 0)
				continue;
			System.out.println(i);
		}
		r();
	}
	
	static void r() {
		double r = 0;
		while(r < 0.99d) {
		  r = Math.random();
		  System.out.println(r);
		}

	}
}
