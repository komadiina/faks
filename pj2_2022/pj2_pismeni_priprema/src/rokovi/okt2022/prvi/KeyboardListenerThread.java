package rokovi.okt2022.prvi;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class KeyboardListenerThread extends Thread {
    public static boolean active = true;
//    public static final Object pausedLock = new Object();
    public Scanner scn = new Scanner(System.in);

    @Override
    public void run() {
        while (active) {
            String option = scn.nextLine();

            if (option.equals("ALARM"))
                this.raiseAlarm();
            else if (option.equals("ALARM_END"))
                this.disableAlarm();
            else if (option.equals("END_SIM"))
                this.setActive(false);
        }

        System.out.println("KeyboardListenerThread deactivated.");
    }

    public void raiseAlarm() {
        System.out.println("Podignut alarm!");
        Firma.alarm = true;
    }

    public void disableAlarm() {
        System.out.println("Ugasen alarm!");
        Firma.alarm = false;
        synchronized (Firma.alarmLock) {
            Firma.alarmLock.notifyAll();
        }
    }

    public void setActive(boolean status) {
        active = status;

        if (!active) {
            try {
                Thread.sleep(TimeUnit.MILLISECONDS.toMillis(1));
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (InterruptedException | AWTException ex) {
                ex.printStackTrace();
            }
        }
    }
}
