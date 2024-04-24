package usmeni.primjercici;

public class LambdaCaptures {
    private int instanceVariable = 0;
    private static int staticVariable = 0;

    public static void main(String[] args) {
        LambdaCaptures lc = new LambdaCaptures();
        lc.method(0);
    }

    public void method(int i) {
        int localVariable = 10;
        Ix var = (n) -> {
            int result = localVariable * 10;
            instanceVariable++;
            staticVariable++;
            System.out.println(localVariable);
            System.out.println(instanceVariable);
            System.out.println(staticVariable);
            System.out.println(n);
            this.method2();
            return result;
        };
        var.func(5);
    }

    private void method2() {
        System.out.println("m2");
    }
}

interface Ix {
    int func(int i);
}
