public class Superman extends Superheroj implements BrzoTrcanje, Letenje, SuperSnaga {
    Superman() {
        super("Clark Kent");
    }

    public void akcija() {
        System.out.println("Let, snaga, trcanje");
    }
}