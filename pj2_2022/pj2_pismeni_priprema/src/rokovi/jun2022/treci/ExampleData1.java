package rokovi.jun2022.treci;

public class ExampleData1 implements Data {
    public String type, color;
    public Integer value;

    public ExampleData1(String type, String color, Integer value) {
        this.type = type;
        this.color = color;
        this.value = value;
    }

    public String getType() { return this.type; }
    public Integer getValue() { return this.value; }
}
