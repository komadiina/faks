
public class UnicodeTest {

	public static void main(String[] args) {
		String прваПромјенљива = "абвгдђежзијклљмнњопрстћуфхцчџш";
		String drugaPromjenljiva = "abcčćddžđefghijklljmnnjoprsštuvzž";
		String unicode = "爪哇";
		String unicode2 = "Приветствия студентам";
		String unicode3 = "વિદ્યાર્થીઓ માટે શુભેચ્છાઓ";
		System.out.println(прваПромјенљива);
		System.out.println(drugaPromjenljiva);
		ЈуникодТест тест = new ЈуникодТест();
		System.out.println(тест.promjenljiva);
		System.out.println(unicode);
		System.out.println(unicode2);
		System.out.println(unicode3);
		台北 t = new 台北();
		System.out.println(t.test);
	}

}

class ЈуникодТест{
	String promjenljiva = "абв_abc";
}

class 台北{
	String test = "test";
}