package lab11_conc.prvi;

public final class Stopwatch extends Thread {
    public Double elapsed = 0.0;
    public boolean enabled = true;
    public static boolean paused = false;
    public static final Object lock = new Object();

    @Override
    public void run() {
        while (enabled) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                break;
            }

            elapsed += 0.10;

            if (Stopwatch.paused) {
                synchronized (Stopwatch.lock) {
                    try {
                        Stopwatch.lock.wait(); // notifyAll
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            }
        }
    }
}
