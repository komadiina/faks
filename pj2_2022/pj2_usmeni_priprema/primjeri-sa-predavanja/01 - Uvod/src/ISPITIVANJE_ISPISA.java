public class ISPITIVANJE_ISPISA {
    public static void main(String[] args) {
        A2 a2 = new A2();
        System.out.println("x");
        A1 a1 = new A1();
    }
}

class ClanA1 {
    public ClanA1() { System.out.println("CLANA1::CONSTRUCTOR");}
}

class ClanA2 {
    public ClanA2() {System.out.println("CLANA2::CONSTRUCTOR");}
}


class A1 {
    // ClanA1 c; // ukoliko se samo kreirana nereferencni objekat -> nema konstr.
    ClanA1 c = new ClanA1();
    
    static {
        System.out.println("A1::STATIC_INIT");
    }
    
    {
        System.out.println("A1::NON_STATIC_INIT");
    }
    
    public A1() {
        System.out.println("A1::CONSTRUCTOR");
    }
}

class A2 extends A1 {
    ClanA2 c = new ClanA2();
    
    static {
        System.out.println("A2::STATIC_INIT");
    }
    
    {
        System.out.println("A2::NON_STATIC_INIT");
    }
    
    public A2() {
        System.out.println("A2::CONSTRUCTOR");
    }
}