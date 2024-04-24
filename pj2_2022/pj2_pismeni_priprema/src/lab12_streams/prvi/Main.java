package lab12_streams.prvi;

public class Main {
    public static void main(String[] args) {
        StringWork concatenation = (s1, s2) -> s1 + s2;
        StringWork concatUpper = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        StringWork concatNanoTime = (s1, s2) -> s1 + s2 + System.nanoTime();

        StringOps operator = new StringOps();

        System.out.println(operator.operateStrings(concatenation, "prvi", "drugi"));
        System.out.println(operator.operateStrings(concatUpper, "prvi", "drugi"));
        System.out.println(operator.operateStrings(concatNanoTime, "prvi", "drugi"));
    }
}
