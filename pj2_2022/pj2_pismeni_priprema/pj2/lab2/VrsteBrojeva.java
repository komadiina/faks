public class VrsteBrojeva {
    private Integer intervalOd;
    private Integer intervalDo;

    public VrsteBrojeva() {
        intervalOd = 1;
        intervalDo = 100;
    }

    public VrsteBrojeva(Integer intervalOd, Integer intervalDo) {
        this.intervalOd = intervalOd;
        this.intervalDo = intervalDo;
    }

    public void prostBroj() {
        for (Integer i = intervalOd; i < intervalDo; i++) {
            Boolean prost = true;

            for (Integer j = i / 2; j > 1; j--) {
                if (i % j == 0) {
                    prost = false;
                    break;
                }
            }

            if (prost)
                System.out.println(i);
        }
    }

    public void faktorijel() {
        for (Integer i = intervalOd; i < intervalDo; i++) {
            Integer faktorijel = faktorijelRec(i);
            System.out.println(faktorijel);
        }
    }

    public void savrsenBroj() {
        for (Integer i = intervalOd; i < intervalDo; i++) {
            Integer suma = 0;

            for (Integer j = i / 2; j > 0; j--)
                if (i % j == 0)
                    suma += j;

            if (suma == i)
                System.out.println(i);
        }
    }

    public void armstrongovBroj() {
        for (Integer i = intervalOd; i < intervalDo; i++) {
            Integer j = i;
            Integer suma = 0;

            while (j > 0) {
                Integer cifra = j % 10;
                Double kub = Math.pow(cifra, 3);
                suma += kub.intValue();

                j /= 10;
            }

            if (i == suma)
                System.out.println(i);
        }
    }

    private Integer faktorijelRec(Integer broj) {
        if (broj == 1)
            return 1;
        else
            return broj * faktorijelRec(broj - 1);
    }

    public static void main(String[] args) {
        VrsteBrojeva vb1 = new VrsteBrojeva();
        VrsteBrojeva vb2 = new VrsteBrojeva(100, 1000);

        System.out.println("-- prosti brojevi`");
        vb1.prostBroj();

        // System.out.println("-- faktorijeli");
        // vb1.faktorijel();

        System.out.println("-- savrseni brojevi");
        vb1.savrsenBroj();

        System.out.println("-- armstrongovi brojevi");
        vb1.armstrongovBroj();

        System.out.println("-- prosti brojevi`");
        vb2.prostBroj();

        // System.out.println("-- faktorijeli");
        // vb2.faktorijel();

        System.out.println("-- savrseni brojevi");
        vb2.savrsenBroj();

        System.out.println("-- armstrongovi brojevi");
        vb2.armstrongovBroj();

    }
}