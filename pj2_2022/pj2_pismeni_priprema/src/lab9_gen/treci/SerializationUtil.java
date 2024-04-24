package lab9_gen.treci;

import java.io.*;

public class SerializationUtil {
    public static <T> T readObject(String filePath) {
        File target = new File(filePath);
        T read = null;

        if (!target.exists()) {
            return null;
        }

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(target));
             ObjectInputStream objIn = new ObjectInputStream(in)) {
            read = (T) objIn.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }

        return read;
    }

    public static <T> boolean saveObject(T object, String fileName) {
        File dest = new File(System.getProperty("user.dir") + File.separator + fileName);

        if (!dest.exists()) {
            try {
                dest.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
        ObjectOutputStream objOut = new ObjectOutputStream(out)) {
            objOut.writeObject(object);
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
}
