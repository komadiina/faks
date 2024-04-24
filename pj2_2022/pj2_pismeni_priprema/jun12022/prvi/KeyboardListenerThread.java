import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;

public class KeyboardListenerThread extends Thread {
	public Scanner scn = new Scanner(System.in);
	public boolean active = true;
	public Teleekran teleekranInstance = null;
	public Nadzornik nadzornikInstance = null;
	
	public KeyboardListenerThread(Teleekran te, Nadzornik nad) {
		this.teleekranInstance = te;
		this.nadzornikInstance = nad;
	}
	
	@Override
	public void run() {
		while (active) {
			String option = scn.nextLine();
			
			if (option.equals("ZAUSTAVI")) {
				this.setActive(false);
				Teleekran.running = false;
				teleekranInstance.interrupt();
			}
			else if (option.equals("PORUKA")) {
				String tekstPoruke = scn.nextLine();
				nadzornikInstance.posaljiPorukuTeleekran(tekstPoruke);
			}
			else if (option.equals("PAUZA")) {
				Teleekran.pauza = true;
				
			}
		}
	}
	
	public void setActive(boolean flag) {
		this.active = flag;
		
		if (this.active == false) {
			try {
				Thread.sleep(TimeUnit.MILLISECONDS.toMillis(1));
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}