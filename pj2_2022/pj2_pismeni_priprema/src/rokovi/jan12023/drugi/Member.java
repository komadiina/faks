package rokovi.jan12023.drugi;

public class Member {
    public String name;
    public Visibility visibility;
    public String type;

    public Member() {
        super();
    }

    public Member(Visibility visibility, String type, String name) {
        super();
        this.visibility = visibility;
        this.type = type;
        this.name = name;
    }
}
