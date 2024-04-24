package lab12_streams.drugi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ArrayList<Osoba> osobe = new ArrayList<>(Arrays.asList(
                new Osoba("Ognjen", "Komadina", 21, false, true),
                new Osoba("Maja", "Mujadzic", 21, false, true),
                new Osoba("Goran", "Komadina", 29, true, true),
                new Osoba("Petar", "Djurdjevic", 21, true, true),
                new Osoba("Ivan", "Zvonar", 22, false, true),
                new Osoba("Djordje", "Milisavljevic", 22, false, false),
                new Osoba("Nikola", "Granolic", 22, true, true),
                new Osoba("Zoran", "Komadina", 55, true, true),
                new Osoba("Aleksandra", "Komadina", 51, true, true)
        ));

        // Predikati
        Predicate<Osoba> imaAuto = Osoba::imaAutomobil;
        Predicate<Osoba> imaKucu = Osoba::imaKucu;
        Predicate<Osoba> izmedju40i60 = (o) -> o.getGodine() > 40 && o.getGodine() < 60;

        System.out.println("----- Osobe sa automobilima");
        processPersons(osobe, imaAuto, System.out::println);

        System.out.println("----- Osobe sa kucom");
        processPersons(osobe, imaKucu, System.out::println);

        System.out.println("----- Osobe izmedju 40 i 60 godina");
        processPersons(osobe, izmedju40i60, System.out::println);
    }

    public static void processPersons(ArrayList<Osoba> osobe, Predicate<Osoba> preduslov, Consumer<Osoba> operacija) {
        for (Osoba o : osobe)
            if (preduslov.test(o))
                operacija.accept(o);
    }
}
