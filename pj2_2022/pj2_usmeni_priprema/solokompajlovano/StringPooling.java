package usmeni.primjercici;

public class StringPooling {
    public static void main(String[] args) {
        String string = "string";
        String s1 = "test string";
        String s2 = "test string";
        String s3 = "test" + " string";
        String s4 = "test" + " " + string;
        String s5 = new String("test string");
        String s6 = ("test " + string).intern();
        System.out.println(s1==s2); // true
        System.out.println(s1==s3); // false
        System.out.println(s1==s4); // false
        System.out.println(s1==s5); // false
        System.out.println(s1==s6); // true
    }
}
