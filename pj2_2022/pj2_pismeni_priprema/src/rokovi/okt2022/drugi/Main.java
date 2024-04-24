package rokovi.okt2022.drugi;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Document.path = System.getProperty("user.dir") + File.separator + "okt22022.txt";
        CopyReader reader = new CopyReader();
        CopyMaker maker = new CopyMaker();

        maker.setFile(Document.path);

        reader.start();
        maker.start();

        try {
            maker.join();

            reader.running = false;
            reader.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
