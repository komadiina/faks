package lab7_io.treci;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class FileExplorer {
    File currentDir;

    public FileExplorer(String root) throws IllegalArgumentException {
        this.currentDir = new File(root);

        if (this.currentDir.isFile())
            throw new IllegalArgumentException(
                    "Cannot be initialized with a file as an argument."
            );
    }

    public void changeDir(String name) {
        if (name.equals(".."))
            this.currentDir = new File(this.currentDir.getParent());
        else {
            File newPath = new File(System.getProperty("user.dir") + File.separator + name);
            if (!newPath.exists()) {
                System.err.println("Directory " + name + " does not exist! Current directory left unchanged.");
            } else {
                this.currentDir = newPath;
            }
        }

        System.out.println(String.format("[FE] Current path: [%1$s].", this.currentDir.toPath()));
    }

    public void listFiles() {
        try {
            List<Path> files = Files.list(this.currentDir.toPath()).toList();
            for (Path p : files) {
                if (p.toFile().isFile())
                    System.out.println(p);
                else
                    System.out.println("<DIR> " + p);
            }
        } catch (IOException ex) {
            System.err.println("Could not list files for path: " + this.currentDir.toPath());
        }
    }

    public void createDir(String name) {
        File newDir = new File(this.currentDir.toPath() + File.separator + name);
        if (!newDir.exists())
            newDir.mkdir();
    }

    public void delete(String target) {
        // File or directory
        File delTarget = new File(target);

        if (delTarget.exists())
            if (!delTarget.delete())
                System.err.println("Could not delete target: " + target);
    }

    public void copyImageFile(String source, String destination) {
        File src = new File(source);
        File dest = new File(destination);

        if (!src.exists()) {
            System.err.println(String.format("Source file does not exist. (%1$s)", source));
            return;
        }

        if (!dest.exists()) {
            try {
                dest.createNewFile();
            } catch (IOException ex) {
                System.err.println("Could not create file: " + destination);
            }

        }

        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dest)) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException ex) {
            System.err.println("Could not copy from: " + source);
        }
    }

    public void listWordDocs() {
        try {
            List<Path> files = Files.list(this.currentDir.toPath()).toList();
            for (Path p : files)
                if (p.endsWith(".doc") || p.endsWith(".txt") && p.toFile().isFile())
                    System.out.println(String.format("- [%1$s]", p));
        } catch (IOException ex) {
            System.err.println("Could not list files for directory: " + this.currentDir.toPath());
        }
    }
}
