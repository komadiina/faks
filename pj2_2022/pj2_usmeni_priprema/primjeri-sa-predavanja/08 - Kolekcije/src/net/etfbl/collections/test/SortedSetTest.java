package net.etfbl.collections.test;

import java.util.*;

public class SortedSetTest {
    public static void main(String args[]) {
        SortedSet<String> s = new TreeSet<String>();
        s.add(new String("C"));
        s.add(new String("B"));
        s.add(new String("A"));
        System.out.println(s.first());
        
        SortedSet<StringBuffer> s2 = new TreeSet<StringBuffer>();
        s2.add(new StringBuffer("C"));
        s2.add(new StringBuffer("B"));
        s2.add(new StringBuffer("A"));
        System.out.println(s2.first());
    }
}
