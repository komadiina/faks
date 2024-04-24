package usmeni.primjercici;

import java.io.*;
import java.util.Date;

public class Serializing {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        Logon a = new Logon("Marko", "mark0passw0rd");
        System.out.println( "logon a = " + a);
        ObjectOutputStream o =
                new ObjectOutputStream(
                        new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();
        int seconds = 5;
        long t = System.currentTimeMillis()
                + seconds * 1000;
        while(System.currentTimeMillis() < t)
            ;
        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream("Logon.out"));
        System.out.println(
                "Recovering object at " + new Date());
        a = (Logon)in.readObject();
        System.out.println( "logon a = " + a);
    }
}

class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    public String toString() {
        return "logon info: \n " +
                "username: " + username +
                "\n date: " + date +
                "\n password: " + password;
    }
}
