public class arrays {
    public char[] slova;
    public int[][] tablica = new int[11][11];

    public arrays() {
        for (int i = 0; i <= 10; i++)
            for (int j = 0; j <= 10; j++)
                tablica[i][j] = i * j;
    }

    public void setSlova(char[] s) {
        slova = s;
    }

    public void ispis() {
        printSlova();
        printTablica();
    }

    public void printSlova() {
        for (int i = 0; i < slova.length; i++)
            System.out.println("slova[" + i + "] = " + slova[i]);

    }

    public void printTablica() {
        for (int i = 0; i < tablica.length; ++i) {
            for (int j = 0; j < tablica[i].length; ++j)
                System.out.print(tablica[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        arrays a = new arrays();
        a.setSlova(new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' });
        a.ispis();
    }
}
