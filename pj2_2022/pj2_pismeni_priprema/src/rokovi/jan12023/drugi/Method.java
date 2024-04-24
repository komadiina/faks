package rokovi.jan12023.drugi;

import java.util.*;

public class Method {
    public String name;
    public Visibility visibility;
    public String returnType;
    public List<Parameter> parameters;

    public Method() {
        super();
        this.parameters = new ArrayList<>();
    }

    public Method(Visibility visibility, String returnType, String name, List<Parameter> parameters) {
        super();
        this.visibility = visibility;
        this.returnType = returnType;
        this.name = name;
        this.parameters = parameters;
    }
}
