package usmeni.Z4;

public class Test implements I {
    public void metoda() {
        System.out.println("TestMetoda");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.metoda();
        ((I)t).metoda();

        X x = new X();
        x.metoda();
        ((I)x).metoda();
    }
}

class X implements I {}

interface I {
    default void metoda() {
        System.out.println("IMetoda");
    }
}
