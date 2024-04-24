import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.StandardWatchEventKinds.*;
import java.util.logging.*;
import java.util.function.*;

public class FileWatcher extends Thread {
	public String rootDir;
	public WatchService watcher;
	public boolean active = true;
	
	public FileWatcher(String rootDir) { 
		this.rootDir = rootDir;

		try {
			this.watcher = FileSystems.getDefault().newWatchService();
			Paths.get(rootDir).register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
		} catch (Exception ex) {ex.printStackTrace();}
	}

	@Override
	public void run() {
		System.out.println("WatchService started for: " + this.rootDir);
		
		while (active) {
			try {
			WatchKey key = watcher.take();
			
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE)) {
					Path filePath = ((WatchEvent<Path>)event).context();
					System.out.println("Path: " + filePath.toString());
				}
				else if (event.kind().equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
					// Kreiran novi predmet u predmeti.txt;
					if ((WatchEvent<Path>)event.context().toString().equals("predmeti.txt"))
					{
						// kreirajNoviPredmet();
					}
				}
				else if (event.kind().equals(StandardWatchEventKinds.ENTRY_DELETE)) {
					// doNothing();
				}
			}
			
			key.reset(); 
			} catch (Exception ex) { ex.printStackTrace(); }
		}
		
		
		System.out.println("WatchService ended for: " + this.rootDir);
	}
}