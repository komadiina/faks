package rokovi.jan12023.prvi;

import java.util.Random;

public class NapredniAmater extends Amater {
    public boolean baciKuglu() {
        System.out.println("Amater baca kuglu na dodatnim sinama...");
        return (new Random()).nextInt(100) < 50;
    }
}
