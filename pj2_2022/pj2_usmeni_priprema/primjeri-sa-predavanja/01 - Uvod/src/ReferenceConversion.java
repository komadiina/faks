
public class ReferenceConversion {

	public static void main(String[] args) {
		String s = new String("abc");
		Object o = s;
		String s2 = (String) o;
		System.out.println(s2);
//		Integer i1 = (Integer)s2;
		Integer i2 = (Integer) o;
	}

}
