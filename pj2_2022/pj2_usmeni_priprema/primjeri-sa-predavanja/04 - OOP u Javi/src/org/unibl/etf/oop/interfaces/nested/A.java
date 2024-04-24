package org.unibl.etf.oop.interfaces.nested;

public class A {
    public interface I1 {
        void method1();
    }

    public class X implements I1 {
        @Override
        public void method1() {
        }
    }
}

class B implements A.I1 {
    @Override
    public void method1() {

    }
}
