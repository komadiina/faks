package net.etfbl.collections.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayListVsLinkedListTest {
	static int SIZE = 100000;
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		Calendar  start = Calendar.getInstance();
		for(int i=0; i<SIZE; i++)
			ll.add(i);
		Calendar end = Calendar.getInstance();
		System.out.println("LinkedList insertion time: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		for(int i=0; i<SIZE; i++)
			al.add(i);
		end = Calendar.getInstance();
		System.out.println("ArrayList insertion time: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		for(int i=0; i<ll.size(); i++)
			ll.get(i);
		end = Calendar.getInstance();
		System.out.println("LinkedList iteration time, without Iterator (classic for loop): " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		for(Integer i: ll)
			;
		end = Calendar.getInstance();
		System.out.println("LinkedList iteration time, internal Iterator (for-each loop): " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		for (Iterator<Integer> it = ll.iterator(); it.hasNext();) 
			it.next();
		end = Calendar.getInstance();
		System.out.println("LinkedList iteration time, with Iterator: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		for(int i=0; i<al.size(); i++)
			al.get(i);
		end = Calendar.getInstance();
		System.out.println("ArrayList iteration time, without Iterator (classic for loop): " + (end.getTimeInMillis()-start.getTimeInMillis()));
		
		start = Calendar.getInstance();
		for(Integer i: al)
			;
		end = Calendar.getInstance();
		System.out.println("ArrayList iteration time, internal Iterator (for-each loop): " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		for (Iterator<Integer> it = al.iterator(); it.hasNext();) 
			it.next();
		end = Calendar.getInstance();
		System.out.println("ArrayList iteration time, with Iterator: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		ll.contains(25000);
		end = Calendar.getInstance();
		System.out.println("LinkedList search time: " + (end.getTimeInMillis()-start.getTimeInMillis()));
		
		start = Calendar.getInstance();
		al.contains(25000);
		end = Calendar.getInstance();
		System.out.println("ArrayList search time: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		ll.remove(25000);
		end = Calendar.getInstance();
		System.out.println("LinkedList remove time: " + (end.getTimeInMillis()-start.getTimeInMillis()));
		
		start = Calendar.getInstance();
		al.remove(25000);
		end = Calendar.getInstance();
		System.out.println("ArrayList remove time: " + (end.getTimeInMillis()-start.getTimeInMillis()));
	}

}
