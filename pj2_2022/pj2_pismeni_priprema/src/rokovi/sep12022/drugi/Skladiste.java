package rokovi.sep12022.drugi;

import java.util.*;
import java.util.function.*;

public class Skladiste {
    private PriorityQueue<Element> red = new PriorityQueue<>();

    public void dodajElement(Element el) {
        red.add(el);
    }

    public Element skiniPrvi() {
        return red.poll();
    }

    public void ispisiSve() {
        this.red.forEach(x -> System.out.println(x.toString()));
    }

    public void izvrsi() {
        this.red.forEach(Element::akcija);
    }

    public void pretrazi(List<Predicate<Element>> uslovi, Consumer<Element> izvrsilac) {
        for (Element el : this.red) {
            Boolean isOk = true;

            for (Predicate<Element> uslov : uslovi)
                isOk = isOk && uslov.test(el);

            if (isOk)
                izvrsilac.accept(el);
        }
    }
}
