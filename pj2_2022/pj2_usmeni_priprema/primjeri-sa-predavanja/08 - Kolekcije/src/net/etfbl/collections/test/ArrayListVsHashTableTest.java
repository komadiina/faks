package net.etfbl.collections.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayListVsHashTableTest {
	static int SIZE = 10_000_000;
	
	public static void main(String[] args) {
//		ArrayList<Integer> al = new ArrayList<Integer>();
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>(10_000_001,1);
		
		Calendar  start = Calendar.getInstance();
		for(int i=0; i<SIZE; i++)
			ht.put(i, i);
		Calendar end = Calendar.getInstance();
		System.out.println("Hashtable insertion time: " + (end.getTimeInMillis()-start.getTimeInMillis()));

//		start = Calendar.getInstance();
//		for(int i=0; i<SIZE; i++)
//			al.add(i);
//		end = Calendar.getInstance();
//		System.out.println("ArrayList insertion time: " + (end.getTimeInMillis()-start.getTimeInMillis()));

//		start = Calendar.getInstance();
//		for(int i=0; i<ht.size(); i++)
//			ht.get(i);
//		end = Calendar.getInstance();
//		System.out.println("Hashtable iteration time, without Iterator: " + (end.getTimeInMillis()-start.getTimeInMillis()));
//		
//		start = Calendar.getInstance();
//		for(int i=0; i<al.size(); i++)
//			al.get(i);
//		end = Calendar.getInstance();
//		System.out.println("ArrayList iteration time, without Iterator: " + (end.getTimeInMillis()-start.getTimeInMillis()));
		
//		start = Calendar.getInstance();
//		ht.containsKey(25000);
//		end = Calendar.getInstance();
//		System.out.println("Hashtable search time: " + (end.getTimeInMillis()-start.getTimeInMillis()));
//		
//		start = Calendar.getInstance();
//		al.contains(25000);
//		end = Calendar.getInstance();
//		System.out.println("ArrayList search time: " + (end.getTimeInMillis()-start.getTimeInMillis()));
//
//		start = Calendar.getInstance();
//		ht.remove(25000);
//		end = Calendar.getInstance();
//		System.out.println("Hashtable remove time: " + (end.getTimeInMillis()-start.getTimeInMillis()));
//		
//		start = Calendar.getInstance();
//		al.remove(25000);
//		end = Calendar.getInstance();
//		System.out.println("ArrayList remove time: " + (end.getTimeInMillis()-start.getTimeInMillis()));
	}

}
