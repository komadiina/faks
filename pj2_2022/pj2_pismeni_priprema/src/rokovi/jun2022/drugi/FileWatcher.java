package rokovi.jun2022.drugi;

import lab11_conc.cetvrti.Watcher;

import java.io.*;
import java.nio.file.*;

public class FileWatcher extends Thread {
    public WatchService watcher;
    public String directory;
    public boolean isRunning = true;

    public FileWatcher(String directory) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.directory = directory;
    }

    @Override
    public void run() {

    }
}
