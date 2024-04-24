package rokovi.sep12022.prvi;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.*;

public class Restoran extends Thread {
    public static Integer ID = 0;
    public String idRestorana = (++ID).toString();

    public List<Stol> zaPusace, zaNepusace;
    public Meni meni;
    public final Object zvono = new Object();
    public static boolean otvoren = true;

    public GrupaGostiju naVratima = null;

    public Restoran(List<Stol> zaPusace, List<Stol> zaNepusace, Meni meni) {
        this.zaPusace = zaPusace;
        this.zaNepusace = zaNepusace;
        this.meni = meni;
    }

    @Override
    public void run() {
        while (otvoren) {
            try {
                synchronized (this.zvono) {
                    this.zvono.wait();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            assert this.naVratima != null;

            if (!this.usluzi(this.naVratima))
                this.naVratima.odbijeni = true;

            Double cijenaNarudzbe = this.naVratima.usluziMeni(this.meni);
            if (cijenaNarudzbe > this.naVratima.sumarnoNovca())
                this.naVratima.odbijeni = true;

            if (!this.naVratima.odbijeni) {
                this.naVratima.uzivaj();
            }
        }
    }

    public boolean smjesti(GrupaGostiju grupica) {
        // sadoa daks adsnl
        return true;
    }

    public boolean usluzi(GrupaGostiju grupica) {
        // ima vegetarijance, nema hrane
        if (grupica.sadrziVegetarijance() && !this.imaVegetarijanskeHrane()) {
            log(String.format("[%1$s] Grupa #%2$s odbijena: Nema vegetarijanske hrane.%n",
                    this.idRestorana, grupica.idGrupe));
            return false;
        }

        if (grupica.sadrziPusace() && this.imaSlobodnihStolova(zaPusace, grupica.brojGostiju()))
            return usluziUtil(grupica, zaPusace);
        else if (!(!grupica.sadrziPusace() && this.imaSlobodnihStolova(zaNepusace, grupica.brojGostiju()))) {
            log(String.format("[%1$s] Grupa #%2$s odbijena: Nema stolova za pusace.%n",
                    this.idRestorana, grupica.idGrupe));
            return false;
        }

        if (!grupica.sadrziPusace() && this.imaSlobodnihStolova(zaNepusace, grupica.brojGostiju()))
            return usluziUtil(grupica, zaNepusace);
        else {
            log(String.format("[%1$s] Grupa #%2$s odbijena: Nema stolova za nepusace.%n",
                    this.idRestorana, grupica.idGrupe));
            return false;
        }
    }

    public boolean usluziUtil(GrupaGostiju grupica, List<Stol> stolovi) {
        // ...
        return true;
    }

    public boolean imaSlobodnihStolova(List<Stol> stolovi, Integer brojGostiju) {
        for (Stol s : stolovi)
            if (!s.zauzet && brojGostiju <= s.kapacitet)
                return true;

        return false;
    }

    public boolean imaVegetarijanskeHrane() {
        return meni.imaVegetarijanskuHranu();
    }

    public Stol nadjiStol(List<Gost> grupaGostiju) {
        // Provjeri pusace
        Boolean sadrziPusace = false;
        for (Gost g : grupaGostiju)
            if (g instanceof Pusac p) {
                sadrziPusace = true;
                break;
            }

        // Provjeri vegetarijance
        Boolean sadrziVegetarijance = false;
        for (Gost g : grupaGostiju)
            if (g instanceof Vegetarijanac veg) {
                sadrziVegetarijance = true;
                break;
            }

        // Provjeri ima li vegetarijanske hrane
        if (sadrziVegetarijance && !this.imaVegetarijanskeHrane())
            return null;

        // Nadji odg. sto (pusaci/nepusaci)
        if (sadrziPusace)
            return nadjiStolUtil(grupaGostiju, zaPusace);
        else
            return nadjiStolUtil(grupaGostiju, zaNepusace);
    }

    private Stol nadjiStolUtil(List<Gost> grupaGostiju, List<Stol> stolovi) {
        for (Stol sto : stolovi)
            if (sto.kapacitet <= grupaGostiju.size())
                return sto;

        return null;
    }

    private void log(String poruka) {
        try {
            File file = new File(idRestorana);
            if (!file.exists())
                file.createNewFile();
            Files.write(file.toPath(), poruka.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
