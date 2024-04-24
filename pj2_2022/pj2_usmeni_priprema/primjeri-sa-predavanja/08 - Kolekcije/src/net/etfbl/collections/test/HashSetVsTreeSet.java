package net.etfbl.collections.test;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HashSetVsTreeSet {
	static int LOOPS = 10;
	static int SIZE = 100; // 100_000;//1000

	public static void main(String[] args) throws InterruptedException {
		HashSet<Integer> hs = new HashSet<Integer>();
		TreeSet<Integer> ts = new TreeSet<Integer>();

		Calendar  start = Calendar.getInstance();
		for(int i=0; i<LOOPS; i++){
			hs.clear();
			for(int j=0; j<SIZE; j++)
				hs.add((int) (Math.random()*j));
		}
		Calendar end = Calendar.getInstance();
		System.out.println("HashSet insertion time: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		for(int i=0; i<LOOPS; i++){
			ts.clear();
			for(int j=0; j<SIZE; j++)
				ts.add((int) (Math.random()*j));
		}
		end = Calendar.getInstance();
		System.out.println("TreeSet insertion time: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		Thread.sleep(3000);
//		start = Calendar.getInstance();
//		for(int i=0; i<hs.size(); i++)
//			hs.get(i);
//		end = Calendar.getInstance();
//		System.out.println("HashSet iteration time, without Iterator: " + (end.getTimeInMillis()-start.getTimeInMillis()));
//
//		start = Calendar.getInstance();
//		for(int i=0; i<ts.size(); i++)
//			ts.get(i);
//		end = Calendar.getInstance();
//		System.out.println("TreeSet iteration time, without Iterator: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		for(int i=0; i<LOOPS; i++){
			Iterator<Integer> it = hs.iterator();
	        while(it.hasNext())
	        	System.out.print(i + ":" + it.next() + "  ");
	    }
		end = Calendar.getInstance();
		System.out.println("HashSet iteration time, with Iterator: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		for(int i=0; i<LOOPS; i++){
			Iterator<Integer> it = ts.iterator();
	        while(it.hasNext())
	        	System.out.print(i + ":" + it.next() + "  ");
	    }
		end = Calendar.getInstance();
		System.out.println("TreeSet iteration time, with Iterator: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		for(int i=0; i<LOOPS; i++){
			for(int j=0; j<SIZE; j++)
				hs.contains(j);
		}
		end = Calendar.getInstance();
		System.out.println("HashSet search time: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		for(int i=0; i<LOOPS; i++){
			for(int j=0; j<SIZE; j++)
				ts.contains(j);
		}
		end = Calendar.getInstance();
		System.out.println("TreeSet search time: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		hs.remove(25000);
		end = Calendar.getInstance();
		System.out.println("HashSet remove time: " + (end.getTimeInMillis()-start.getTimeInMillis()));

		start = Calendar.getInstance();
		ts.remove(25000);
		end = Calendar.getInstance();
		System.out.println("TreeSet remove time: " + (end.getTimeInMillis()-start.getTimeInMillis()));

	}

}
