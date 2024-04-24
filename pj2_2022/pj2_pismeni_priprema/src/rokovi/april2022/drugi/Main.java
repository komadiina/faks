package rokovi.april2022.drugi;

import java.util.*;

public class Main {
    public static final List<String> strings = Arrays.asList("pj2", "okti", "m4", "fmsi");
    public static final List<Status> stati = Arrays.asList(Status.DONE, Status.NEW, Status.PROCESSING);
    public static final List<Double> values = Arrays.asList(90.0, 12.0, 44.5, 42.0, 69.0, 80.1);
    public static final Random rng = new Random();

    public static String getRndString() {
        return strings.get(rng.nextInt(strings.size()));
    }

    public static Status getRndStatus() {
        return stati.get(rng.nextInt(stati.size()));
    }

    public static Double getRndValue() {
        return values.get(rng.nextInt(values.size()));
    }

    public static A generateObjectA() {
        return new A(
                getRndValue(),
                getRndString(),
                getRndStatus()
        );
    }

    public static B generateObjectB() {
        return new B(
                getRndValue(),
                getRndString(),
                getRndStatus()
        );
    }

    public static C generateObjectC() {
        return new C(
                getRndValue(),
                getRndString(),
                getRndStatus()
        );
    }

    public static void main(String[] args) {
        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();
        List<C> listC = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            listA.add(generateObjectA());
            listB.add(generateObjectB());
            listC.add(generateObjectC());
        }

//        System.out.println(listA);
//        System.out.println(listB);
//        System.out.println(listC);

        List<MojInterfejs> grupisano = grupisi(Status.DONE, listA, listB, listC);

        System.out.println(grupisano);
    }

    public static <T extends MojInterfejs> List<T> grupisi(Status argument, List<? extends T>... nizovi) {
        List<T> grupisan = new ArrayList<T>();

        for (List<? extends T> niz : nizovi)
            grupisan.addAll(niz.stream().filter(elem -> elem.getStatus().equals(argument)).toList());

        return grupisan;
    }
}
