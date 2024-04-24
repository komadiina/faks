package org.unibl.etf.nio;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FilesTest {

	public static void main(String[] args) throws IOException {
		Path path = FileSystems.getDefault().getPath("", "data.txt"); 
		List<String> lines = Files.readAllLines(path);
		for (String string : lines) {
			System.out.println(string);
		}
		Path drumsSource = FileSystems.getDefault().getPath("", "drums.wav"); 
		Path drumsTarget = FileSystems.getDefault().getPath("", "drums2.wav"); 
		Files.copy(drumsSource, drumsTarget, StandardCopyOption.COPY_ATTRIBUTES);
	
		
	}

}
