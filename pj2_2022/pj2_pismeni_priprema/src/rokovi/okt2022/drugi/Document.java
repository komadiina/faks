package rokovi.okt2022.drugi;

public class Document {
    public static String path;
    public static final Object lock = new Object();
    public static Integer modificationCount = 10;
}
