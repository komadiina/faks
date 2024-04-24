package rokovi.jun2022.treci;

public class ExampleData2 implements Data {
    String type;
    Integer value, size;

    public ExampleData2(String type, Integer value, Integer size) {
        this.type = type;
        this.value = value;
        this.size = size;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getType() {
        return this.type;
    }
}
