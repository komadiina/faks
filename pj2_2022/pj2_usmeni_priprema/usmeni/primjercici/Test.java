package usmeni.primjercici;

public class Test implements I {
    public void metoda() {
        System.out.println("TestMetoda");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.metoda();         // TestMetoda
        ((I)t).metoda();    // TestMetoda

        X x = new X();
        x.metoda();         // IMetoda
        ((I)x).metoda();    // IMetoda
    }
}

class X implements I {}

interface I {
    default void metoda() {
        System.out.println("IMetoda");
    }
}
