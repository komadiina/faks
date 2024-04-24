package lab7_io.peti;

import java.nio.file.Files;
import java.util.Arrays;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void firstRun() {
        Zaposleni zap = new Zaposleni();

        try {
            List<String> lines = Files.readAllLines(new File("zaposleni.csv").toPath());

            for (String line : lines) {
                String[] tokens = line.split(",");
                if (tokens.length != 4) {
                    System.err.println("Malformed CSV entry: " + line);
                    continue;
                }

                Radnik r = new Radnik(tokens[0], tokens[1], tokens[2]);
                r.vrijemeProvedeno = Integer.parseInt(tokens[3]);
                zap.dodajZaposlenog(r);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("firma.dat"));
        ObjectOutputStream objOut = new ObjectOutputStream(out)) {
            objOut.writeObject((Object)zap);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void saveFirma(Zaposleni firma, String fileName) {
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName));
             ObjectOutputStream objOut = new ObjectOutputStream(out)) {
            objOut.writeObject(firma);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static Zaposleni loadFirma(String fileName) {
        Zaposleni firma = null;

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
             ObjectInputStream objIn = new ObjectInputStream(in)) {
            firma = (Zaposleni) objIn.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return firma;
    }

    private static void displayOptions() {
        System.out.println("[PAUZA] - Pauziranje rada.");
        System.out.println("[OPET] - Otpauziranje rada.");
        System.out.println("[KRAJ] - Prekid rada.");
        System.out.print("> ");
    }

    public static void main(String[] args) {
        firstRun();

        Zaposleni firma = loadFirma("firma.dat");
        System.out.printf("%1$s", firma);

        // Setup
        Scanner scn = new Scanner(System.in);
        String odabir = "";

        // Welcome screen
        System.out.print("Unesite vase korisnicko ime: ");
        String korisnickoIme = scn.nextLine();

        // Database check
        Radnik korisnik = null;
        if (firma.imaZaposlen(korisnickoIme)) {
            korisnik = firma.getRadnik(korisnickoIme);
        } else {
            System.out.print("Ne postoji takav radnik. Zelite li kreirati novi nalog? (y/n): ");
            odabir = scn.nextLine();

            if (odabir.equals("y")) {
                // Kreiranje novog radnika
                korisnik = Radnik.kreiraj(firma);
                firma.dodajZaposlenog(korisnik);
            } else return; // Nema sta
        }

        // Main loop
        odabir = "";
        while (!odabir.equals("KRAJ")) {
            assert korisnik != null;
            korisnik.run();

            displayOptions();
            odabir = scn.nextLine();

            if (odabir.equals("PAUZA")) {
                // Pauziranje rada radnika
                korisnik.pauziran = true;
            } else if (odabir.equals("OPET")) {
                korisnik.pauziran = false;

                synchronized (korisnik.pauzaLock) {
                    korisnik.pauzaLock.notify();
                }
            }
        }

        korisnik.loggedOn = false;
        synchronized (korisnik.pauzaLock) {
            korisnik.pauzaLock.notify();
        }

        System.out.println("Vrijeme provedeno: " + korisnik.vrijemeProvedeno);

        // Save current state
        saveFirma(firma, "firma.dat");
    }
}
