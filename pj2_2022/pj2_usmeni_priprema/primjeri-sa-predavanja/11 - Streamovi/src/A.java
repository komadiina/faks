public class A {
    static int y;
    final int x = y;

    static class stB {
        int x = ++(X);
        static int X = -1;

        public static void foo() {
            System.out.println("X: " + ++X);
        }
    }

    class B {
        int y = 55;

        public void foo() {
            System.out.println("y:" + y);
            System.out.println("A.this.x: " + A.this.x);
        }
    }

    B b = new B();

    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.stB.X);
        A.stB.foo();

        a.b = a.new B();
        a.b.foo();
        A.stB.X = (--A.stB.X);
        A.stB.foo();
    }
}
