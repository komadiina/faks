package lab7_io.peti;

import java.io.Serializable;
import java.util.Scanner;

public final class Radnik implements Serializable, Runnable {
    public String ime, prezime, korisnickoIme;
    public Integer vrijemeProvedeno = 0;
    transient public boolean loggedOn = false;
    transient public boolean pauziran = false;
    public final Object pauzaLock = new Object();

    public Radnik(String ime, String prezime, String korisnickoIme) {
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public void run() {
        this.loggedOn = true;
        System.out.printf("Korisnik [%1$s] prijavljen.", this.korisnickoIme);

        while (this.loggedOn) {
            this.vrijemeProvedeno++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                break;
            }

            if (pauziran)
                try {
                    synchronized (this.pauzaLock)
                    {
                        pauzaLock.wait();
                    }
                } catch (InterruptedException ex) {
                    break;
                }
        }

        System.out.printf("Korisnik [%1$s] odjavljen.", this.korisnickoIme);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        else if (o instanceof Radnik r) {
            return r.korisnickoIme.equals(this.korisnickoIme);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%1$s,%2$s,%3$s,%4$d%n",
                this.ime, this.prezime, this.korisnickoIme, this.vrijemeProvedeno);
    }

    public static Radnik kreiraj(Zaposleni firma) {
        Scanner scn = new Scanner(System.in);
        String ime, prezime, username = "";
        System.out.print("Ime: ");
        ime = scn.nextLine();
        System.out.print("Prezime: ");
        prezime = scn.nextLine();

        // Da ne provjeravam dvaput pozivom na metodu
        boolean postoji = true;
        while (postoji) {
            System.out.print("Korisnicko ime: ");
            username = scn.nextLine();

            if (firma.imaZaposlen((username)))
                System.out.println("Greska: Korisnicko ime zauzeto.");
            else postoji = false;
        }

        return new Radnik(ime, prezime, username);
    }
}
