package rokovi.jan12023.drugi;

import java.util.*;

public class GeneratedClass {
    public String name;
    public List<Member> members = new ArrayList<>();
    public List<Method> methods = new ArrayList<>();

    public String getClassDeclaration() {
        String classBody = String.format("public class %1$s {%n", this.name);
        classBody += getAttributeDeclarations();
        classBody += getDefaultConstructor();
        classBody += getParametrizedConstructor();
        for (Member mem : members) {
            classBody += getGetter(mem);
            classBody += getSetter(mem);
        }

        for (Method method : methods) {
            classBody += getMethod(method);
        }

        classBody += getToString();
        classBody += getEquals();

        classBody += String.format("%n}");
        return classBody;
    }

    public String getAttributeDeclarations() {
        String text = "";
        for (Member mem : members)
            text += String.format("%1$s %2$s %3$s;%n", mem.visibility.toString(), mem.type, mem.name);

        return text;
    }

    public String getDefaultConstructor() {
        return String.format("public %1$s() {}%n", this.name);
    }

    public String getParametrizedConstructor() {
        String text = String.format("public %1$s(", this.name);
        // parameter list
        for (int i = 0; i < members.size() - 1; i++)
            text += String.format("%1$s %2$s, ",
                    members.get(i).type, members.get(i).name);

        // last param
        text += String.format("%1$s %2$s) {%n",
                members.get(members.size()-1).type,
                members.get(members.size()-1).name);

        // assignments
        for (Member mem : members)
            text += String.format("this.%1$s = %2$s;%n", mem.name, mem.name);

        return String.format("%1$s\t}", text);
    }

    public String getEquals() {
        String text = String.format("@Override%npublic boolean equals(Object o) {%n");
        text += String.format("if (o == null) return false;%nif (o instanceof %1$s p) {%n", this.name);
        text += "return ";
        for (int i = 0; i < members.size() - 1; i++)
            text += String.format("this.%1$s == p.%2$s && ",
                    members.get(i).name, members.get(i).name);
        text += String.format("this.%1$s == p.%2$s;}%n\treturn false;%n\t}",
                members.get(members.size() - 1).name,
                members.get(members.size() - 1).name);

        return text;
    }

    public String getToString() {
        String text = String.format("@Override%npublic String toString() { %nreturn String.format(\"");
        for (Member mem : members) {
            text += String.format("%1$s, ", mem.name);
        }

        text += "\");\n}";
        return text;
    }

    public String getMethod(Method m) {
        String text = String.format("%1$s %2$s %3$s(", m.visibility.toString(), m.returnType, m.name);
        for (int i = 0; i < m.parameters.size() - 1; i++)
            text += String.format("%1$s %2$s, ",
                    m.parameters.get(i).type,
                    m.parameters.get(i).name);

        text += String.format("%1$s %2$s) {}%n",
                m.parameters.get(m.parameters.size() - 1).type,
                m.parameters.get(m.parameters.size() - 1).name);

        return text;
    }

    public String getGetter(Member mem) {
        return String.format("public get%1$s() {%nreturn this.%2$s;%n}%n",
                mem.name, mem.name);
    }

    public String getSetter(Member mem) {
        return String.format("public set%1$s(%2$s %3$s) {%nthis.%3$s = %4$s;%n}%n",
                mem.name, mem.type, mem.name, mem.name);
    }
}
