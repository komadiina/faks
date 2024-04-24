package primjer_ispitnih.prvi.parsing;

import java.util.HashMap;
import java.util.Map;

public abstract class Parser<T> extends Thread {
    public String fileName;

    public Map<String, T> data = new HashMap<>();
    public final Integer SPEED = 1000;
    public boolean paused = false;
    public Object lock = new Object();

    public Parser(String fileName) {
        this.fileName = fileName;
    }

    public void checkPause() {
        if (this.paused) {
            synchronized (this.lock) {
                try {
                    this.lock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
