package rokovi.jan12023.prvi;

import java.util.*;

public class Profesionalac extends Igrac {
    public boolean baciKuglu() {
        System.out.println("Profesionalac spinuje kuglu...");
        return (new Random()).nextInt(100) < 75;
    }
}
