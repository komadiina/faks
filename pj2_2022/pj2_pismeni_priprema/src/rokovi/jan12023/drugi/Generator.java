package rokovi.jan12023.drugi;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Generator {
    public String classPath = "";
    public String className = "";

    public Generator() {}

    public Generator(String classPath) {
        this.classPath = classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public void generate() {
        assert !this.classPath.equals("");

        GeneratedClass generatedClass = new GeneratedClass();
        List<String> fileContent = new ArrayList<>();

        try {
            fileContent = Files.readAllLines(Path.of(classPath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        className = Path.of(classPath).getFileName().toString();
        className = className.substring(0, className.lastIndexOf("."));

        // Capitalize
        className = className.substring(0, 1).toUpperCase() + className.substring(1);
        generatedClass.name = className;
        System.out.println(generatedClass.name);

        for (String line : fileContent) {
            if (line.length() == 0)
                continue;

            if (line.contains("("))
                generatedClass.methods.add(parseMethod(line));
            else generatedClass.members.add(parseMember(line));
        }

        String output = generatedClass.getClassDeclaration();

        try {
            File file = new File(String.format("%1$s.java", generatedClass.name));
            if (!file.exists())
                file.createNewFile();

            Files.write(file.toPath(), output.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Successfully generated java-file for: " + generatedClass.name);
    }

    public Method parseMethod(String line) {
        line = line.replace("(", " ");
        line = line.replace(")", " ");
        String[] tokens = line.split(" ");
        Method method = new Method();

        // Visibility
        method.visibility = parseVisibility(tokens[0]);

        // ime
        method.name = tokens[1];

        // ima parametre
        if (tokens.length > 2) {
            List<Parameter> parameters = new ArrayList<>();
            for (int i = 2; i < tokens.length - 2; i += 2) {
                method.parameters.add(new Parameter(getType(tokens[i+1]), tokens[i]));
            }
        }

        method.returnType = tokens[tokens.length-1];
        return method;
    }

    public String getType(String type) {
        if (type.equals("string"))
            return "String";

        return type;
    }

    public Member parseMember(String line) {
        Member mem = new Member();
        String[] tokens = line.split(" ");
        assert tokens.length == 3;
        mem.visibility = parseVisibility(tokens[0]);
        mem.name = tokens[1];
        mem.type = getType(tokens[2]);

        return mem;
    }

    public Visibility parseVisibility(String str) {
        if (str.equals("-")) return Visibility.PRIVATE;
        else if (str.equals("#")) return Visibility.PROTECTED;
        else return Visibility.PUBLIC;
    }
}
