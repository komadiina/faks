public class MatOp {
    private int operand1;
    private int operand2;

    public MatOp() {
        this.operand1 = 10;
        this.operand2 = 2 * this.operand1;
    }

    public MatOp(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public int proizvod() {
        return operand1 * operand2;
    }

    public float kolicnik() {
        return (float) operand1 / (float) operand2;
    }

    public boolean prviVeci() {
        return operand1 > operand2;
    }

    public int sumTwenty() {
        int sum = 0;

        for (int i = 1; i <= 20; ++i)
            sum += i;

        return sum;
    }

    public int modThreeDiff() {
        int sum = 0;

        for (int i = 100; i > 0; --i)
            if (i % 3 == 0)
                sum -= i;

        return sum;
    }

    public static void main(String[] args) {
        MatOp prvi = new MatOp();
        MatOp drugi = new MatOp(2, 3);

        // MatOp prvi; prvi.op1 = 10, prvi.op2 = 20
        System.out.println("Prvi: " + prvi.operand1 + ", drugi: " + prvi.operand2);
        System.out.println("Proizvod: " + prvi.proizvod());
        System.out.println("Kolicnik: " + prvi.kolicnik());
        System.out.println("Prvi veci: " + prvi.prviVeci());
        System.out.println("Suma prvih 20: " + prvi.sumTwenty());
        System.out.println("Suma svih deljivih sa 3: " + prvi.modThreeDiff());

        // MatOp drugi
        System.out.println("\nPrvi: " + drugi.operand1 + ", drugi: " + drugi.operand2);
        System.out.println("Proizvod: " + drugi.proizvod());
        System.out.println("Kolicnik: " + drugi.kolicnik());
        System.out.println("Prvi veci: " + drugi.prviVeci());
        System.out.println("Suma prvih 20: " + drugi.sumTwenty());
        System.out.println("Suma svih deljivih sa 3: " + drugi.modThreeDiff());
    }
}
