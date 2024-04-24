package rokovi.jan12023.drugi;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.setClassPath(System.getProperty("user.dir") + File.separator + "narudzbenica.txt");
        generator.generate();
    }
}
