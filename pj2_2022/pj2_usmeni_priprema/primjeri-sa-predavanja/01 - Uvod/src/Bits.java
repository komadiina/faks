
public class Bits {

	public static void main(String[] args) {
		int a = 15; // 0000 1111
		a = a >> 1; // 0000 0111, 0 -> 00, 1 -> 11
		System.out.println(a + "  " + Integer.toBinaryString(a));
		a = a >> 1;
		System.out.println(a + "  " + Integer.toBinaryString(a));
		a = a >> 1;
		System.out.println(a + "  " + Integer.toBinaryString(a));
		a = a >> 1;
		System.out.println(a + "  " + Integer.toBinaryString(a));
		a = a >> 1;
		System.out.println(a + "  " + Integer.toBinaryString(a));
		System.out.println("==========");
		a = 1;
		a = a << 1;
		System.out.println(a + "  " + Integer.toBinaryString(a));
		a = a << 1;
		System.out.println(a + "  " + Integer.toBinaryString(a));
		a = a << 1;
		System.out.println(a + "  " + Integer.toBinaryString(a));
		a = a << 1;
		System.out.println(a + "  " + Integer.toBinaryString(a));
//		System.out.println("==========");
//		a = -1;
//		a = a << 1;
//		System.out.println(a + "  " + Integer.toBinaryString(a));
//		a = a << 1;
//		System.out.println(a + "  " + Integer.toBinaryString(a));
//		a = a << 1;
//		System.out.println(a + "  " + Integer.toBinaryString(a));
		
		a = 1;
		System.out.println(a + "  " + Integer.toBinaryString(a));
		int b = -a;
		System.out.println(b);
		System.out.println(b + "  " + Integer.toBinaryString(b));
	}

}
