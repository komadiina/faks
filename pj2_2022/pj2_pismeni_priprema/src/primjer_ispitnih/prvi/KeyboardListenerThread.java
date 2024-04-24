package primjer_ispitnih.prvi;

import primjer_ispitnih.prvi.parsing.Parser;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class KeyboardListenerThread extends Thread {
    public List<Parser<?>> parserList = new ArrayList<>();
    public static final Object lock = new Object();
    public Scanner scn = new Scanner(System.in);
    public boolean active = true;

    public KeyboardListenerThread(List<Parser<?>> parsers) {
        for (Parser<?> p : parsers) {
            this.parserList.add(p);
            p.lock = lock;
        }
    }

    @Override
    public void run() {
        while (active) {
            String input = scn.nextLine();

            if (input.equals("wait"))
                parserList.forEach(p -> p.paused = true);
            else if (input.equals("go"))
            {
                parserList.forEach(p -> p.paused = false);
                synchronized (lock) {
                    lock.notifyAll();
                }
            } else if (input.equals("stop"))
                this.setActive(false);
        }

        scn.close();
    }

    public void setActive(boolean status) {
        this.active = status;

        if (!this.active) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (InterruptedException | AWTException ex) {
                ex.printStackTrace();
            }
        }
    }
}
