package lab7_io.treci;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileExplorer fe = new FileExplorer(System.getProperty("user.dir"));
        fe.listFiles();
        fe.changeDir("src");
        fe.listFiles();
    }
}
