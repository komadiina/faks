package rokovi.jan12023.prvi;

import java.util.*;
import java.util.logging.*;
import java.util.function.*;
import java.util.logging.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.math.*;

public class Main {
    public static List<Igrac> kreirajIgrace() {
        List<Igrac> igraci = new ArrayList<>();
        igraci.add(new Profesionalac());
        igraci.add(new Profesionalac());
        igraci.add(new PocetnikAmater());
        igraci.add(new NapredniAmater());
        return igraci;
    }

    public static List<Tim> kreirajTimove() {
        List<Tim> timovi = new ArrayList<>(Arrays.asList(
                new Tim("tim1", kreirajIgrace()),
                new Tim("tim2", kreirajIgrace()),
                new Tim("tim3", kreirajIgrace()),
                new Tim("tim4", kreirajIgrace()),
                new Tim("tim5", kreirajIgrace()),
                new Tim("tim6", kreirajIgrace()),
                new Tim("tim7", kreirajIgrace()),
                new Tim("tim8", kreirajIgrace())
        ));
        return timovi;
    }

    public static void main(String[] args) {
        List<Liga> lige = new ArrayList<>(Arrays.asList(
                new Liga("liga1", kreirajTimove()),
                new Liga("liga2", kreirajTimove()),
                new Liga("liga3", kreirajTimove()),
                new Liga("liga4", kreirajTimove()),
                new Liga("liga5", kreirajTimove()),
                new Liga("liga6", kreirajTimove()),
                new Liga("liga7", kreirajTimove()),
                new Liga("liga8", kreirajTimove())
        ));
    }
}
