package rokovi.april2022.prvi;

import java.util.*;

public class Utils {
    public static Motor generisiMotor() {
        Random rng = new Random();
        Integer choice = rng.nextInt(4);

        if (choice.equals(0))
            return Motor.BENZIN;
        else if (choice.equals(1))
            return Motor.DIZEL;
        else if (choice.equals(2))
            return Motor.ELEKTRICNI;
        else return Motor.HIBRID;
    }
}
