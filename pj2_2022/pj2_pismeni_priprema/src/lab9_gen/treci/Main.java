package lab9_gen.treci;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    private static class A implements Serializable {
        public Integer broj;
        public String tekst;

        public A(Integer broj, String tekst) {
            this.broj = broj;
            this.tekst = tekst;
        }

        @Override
        public String toString() {
            return String.format("%1$d%n%2$s", this.broj, this.tekst);
        }
    }

    private static class B implements Serializable {
        public List<Integer> brojevi;
        public HashSet<String> tekstovi;

        public B(List<Integer> brojevi, HashSet<String> tekstovi) {
            this.brojevi = brojevi;
            this.tekstovi = tekstovi;
        }

        @Override
        public String toString() {
            return String.format("%1$s%n%2$s", this.brojevi, this.tekstovi);
        }
    }

    public static void main(String[] args) {
        A a1 = new A(5, "eheh");
        A a2 = new A(10, "axax");

        B b1 = new B(Arrays.asList(5, 10, 15), new HashSet<>(Arrays.asList("xaxa", "hehe")));

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b1);

        SerializationUtil.saveObject(a1, "a1.dat");
        SerializationUtil.saveObject(a2, "a2.dat");
        SerializationUtil.saveObject(b1, "b1.dat");

        A readA1 = SerializationUtil.readObject("a1.dat"),
                readA2 = SerializationUtil.readObject("a2.dat");
        B readB1 = SerializationUtil.readObject("b1.dat");

        System.out.println(readA1);
        System.out.println(readA2);
        System.out.println(readB1);
    }
}
