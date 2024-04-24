package rokovi.jun2022.treci;

import java.util.function.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Data> exampleData1s = new ArrayList<>(Arrays.asList(
                new ExampleData1("XX", "CRVENA", 50),
                new ExampleData1("XX", "ZUTA", 50),
                new ExampleData1("XY", "CRVENA", 10)
        ));

        List<Data> exampleData2s = new ArrayList<>(Arrays.asList(
                new ExampleData2("XX", 50, 5),
                new ExampleData2("XY", 99, 2),
                new ExampleData2("XY", 5, -10)
        ));

        Predicate<Data> pred1 = x -> x.getType().equals("XX"),
                pred2 = x -> x.getValue() > 10,
                pred3 = x -> x.getValue() * x.getValue() > 100;
        List<Predicate<Data>> predikati = new ArrayList<>(Arrays.asList(pred1, pred2, pred3));
        Consumer<Data> dataConsumer = x -> System.out.println(x.getType());

        List<Data> obradjeni = processData(predikati, dataConsumer, exampleData1s, exampleData2s);
        obradjeni.forEach(x -> System.out.println(x.getType() +","+x.getValue()));
    }

    @SafeVarargs
    public static <T extends Data> List<T> processData(List<Predicate<T>> uslovi, Consumer<T> potrosac, List<T>... objekti) {
        List<T> pokupljeni = new ArrayList<>();

        for (List<T> listaObjekata : objekti) {
            for (T objekat : listaObjekata) {
                potrosac.accept(objekat);

                boolean isOk = true;
                for (Predicate<T> uslov : uslovi)
                    isOk = isOk && uslov.test(objekat);

                if (isOk) pokupljeni.add(objekat);
            }
        }

        return pokupljeni;
    }
}
