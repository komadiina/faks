package rokovi.jun2022.prvi;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class KeyboardListenerThread extends Thread {
    public Scanner input = new Scanner(System.in);
    public boolean running = true;
    public static final Object globalPauseLock = new Object();
    public static boolean paused = false;

    @Override
    public void run() {
        while (running) {
            String option = input.nextLine();

            if (option.equals("PAUZA")) {
                paused = true;
            } else if (option.equals("NASTAVAK")) {
                paused = false;
                synchronized (globalPauseLock) {
                    globalPauseLock.notifyAll();
                }
            } else if (option.equals("ZAUSTAVI")) {
                this.setActive(false);
                break;
            }
        }
    }

    public void setActive(boolean status) {
        this.running = status;

        if (!this.running) {
            try {
                Thread.sleep(TimeUnit.NANOSECONDS.toMillis(1));
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (InterruptedException | AWTException ex) {
                ex.printStackTrace();
            }
        }
    }
}
