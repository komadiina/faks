package rokovi.okt2022.drugi;

import javax.print.Doc;
import java.nio.file.*;

public class CopyReader extends Thread {
    public boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                WatchService watcher = FileSystems.getDefault().newWatchService();
                Path.of(Document.path).getParent().register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
                WatchKey key = watcher.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind().equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
                        synchronized (Document.lock) {
                            System.out.println(Files.readAllLines(Path.of(Document.path)));
                        }
                    }
                }

                key.reset();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
