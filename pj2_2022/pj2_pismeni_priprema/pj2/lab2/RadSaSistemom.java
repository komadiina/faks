import java.util.*;

public class RadSaSistemom {
    public static void main(String[] args) {
        String[] osobine = { "java.version", "java.home", "os.name", "user.home" };
        Properties properties = System.getProperties();

        for (String osobina : osobine) {
            String vrijednost = properties.getProperty(osobina);
            System.out.println(osobina + " -> " + vrijednost);
        }
    }
}
