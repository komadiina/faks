package lab11_conc.treci;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Random;

public final class ProizvodnaTraka extends Thread {
    public Object[] traka = new Object[10];
    public String brojTrake, tipProizvoda;
    public Integer brzinaRada;

    private Random rng = new Random();

    public ProizvodnaTraka(String brojTrake, String tipProizvoda) {
        this.brojTrake = brojTrake;
        this.tipProizvoda = tipProizvoda;
        this.brzinaRada = rng.nextInt(2000);
    }

    @Override
    public void run() {
        System.out.printf("Traka %1$s: brzina=%2$d%n", this.brojTrake, this.brzinaRada);

        int napravljeno = 0;
        LocalDateTime ldt = LocalDateTime.now();
        while (napravljeno < 10) {
            // Pravljenje proizvoda
            Proizvod p = new Proizvod(this.tipProizvoda,
                    "SN: " + this.brojTrake + "_" + ldt);

            this.traka[napravljeno] = p;
            napravljeno++;

            this.zapisi(p);
            this.serijalizuj(p, napravljeno);

            // Brzina rada
            try {
                Thread.sleep(this.brzinaRada);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            // Zastoj
            if (rng.nextInt(100) < 10) {
                System.out.printf("Zastoj! (%1$s)%n", this.brojTrake);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            // Kvar
            if (rng.nextInt(100) < 5) {
                break;
            }
        }

        System.out.printf("Traka %1$s zavrsila sa radom.%n", this.brojTrake);
    }

    private synchronized void zapisi(Proizvod p) {
        File file = new File("proizvodi.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath(), true))) {
            writer.write(String.format("Traka [%1$s] je napravila proizvod %2$s.%n",
                    this.brojTrake, p.serijskiBroj));
        } catch (IOException ex) {
            System.err.println("Nije moguce zapisati proizvod: " + p.serijskiBroj);
        }
    }

    private void serijalizuj(Proizvod p, int redniBroj) {
        File file = new File(System.getProperty("user.dir") + File.separator + "proizvodi");
        if (!file.exists())
            file.mkdirs();

        file = new File(file.getPath() + File.separator + String.format("%1$s_%2$d.dat",
                this.brojTrake, redniBroj));

        try {
            file.createNewFile();
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file.getPath()));
            ObjectOutputStream objOut = new ObjectOutputStream(out);

            objOut.writeObject(p);

            out.close();
            objOut.close();
        } catch (Exception ex) {
            System.err.println("Nije moguce serijalizovati proizvod.");
        }
    }

    public void analiza() {
        Integer napravljeno = 0, ispravni = 0, pokvareni = 0;

        for (int i =0; i < 10; i++) {
            if (this.traka[i] != null) {
                napravljeno++;

                if (((Proizvod)this.traka[i]).imaGresku)
                    pokvareni++;
                else ispravni++;
            }
        }

        Double uspjesnost = (double)(ispravni) / (double)(napravljeno);

        System.out.printf("--> Traka #%1$s:%n\t- Napravljeno: %2$d%n\t- Ispravno: %3$d%n\t- Pokvareno: %4$d%n\t- Uspjesnost: %5$.2f%n",
                this.brojTrake, napravljeno, ispravni, pokvareni, uspjesnost);
    }
}
