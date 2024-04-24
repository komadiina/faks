package rokovi.april2022.drugi;

public class A implements MojInterfejs {
    Double value;
    String name;
    Status status;

    public A(Double value, String name, Status status) {
        this.value = value;
        this.name = name;
        this.status = status;
    }

    @Override
    public Double getValue() {
        return this.value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        String status = this.status.equals(Status.DONE) ? "DONE" :
                this.status.equals(Status.NEW) ? "NEW" : "PROCESSING";

        return String.format("name: %1$s, value: %2$.1f, status: %3$s",
                this.name, this.value, status);
    }
}
