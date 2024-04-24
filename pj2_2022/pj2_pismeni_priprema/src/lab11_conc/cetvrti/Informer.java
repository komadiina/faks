package lab11_conc.cetvrti;

import java.util.ArrayList;
import java.util.List;

public final class Informer extends Thread {
    public boolean running = true;
    public List<String> events = new ArrayList<>();
    public final Object waitLock = new Object();
    public final Object eventsLock = new Object();
    public String buffer = null;

    @Override
    public void run() {
        // producer --> consumer

        while (this.running) {
            // Wait for event
            synchronized (this.waitLock) {
                try {
                    this.waitLock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            // Awoken --> event popped
            // Redundancy check
            if (this.buffer == null)
                continue;

            synchronized (this.eventsLock)
            {
                this.events.add(this.buffer);
                this.buffer = null;
            }
        }
    }
}
