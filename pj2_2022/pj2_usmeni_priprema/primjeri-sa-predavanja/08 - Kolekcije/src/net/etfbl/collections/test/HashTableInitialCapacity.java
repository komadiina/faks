package net.etfbl.collections.test;

import java.util.Calendar;
import java.util.Hashtable;

public class HashTableInitialCapacity {


	private static final int SIZE = 300_000;
	private static final int LOOPS = 3;

	public static void main(String[] args) {

		Calendar  start = Calendar.getInstance();
		for(int j=0; j<LOOPS; j++){
			Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
			for(int i=0; i<SIZE; i++)
				ht.put(i, i);
		}
		Calendar end = Calendar.getInstance();
		System.out.println("Hashtable avg. insertion time: " + (end.getTimeInMillis()-start.getTimeInMillis())/LOOPS);

		start = Calendar.getInstance();
		for(int j=0; j<LOOPS; j++){
			Hashtable<Integer, Integer> ht2 = new Hashtable<Integer, Integer>(300001, 1);
			for(int i=0; i<SIZE; i++)
				ht2.put(i, i);
		}
		end = Calendar.getInstance();
		System.out.println("Hashtable avg. insertion time: " + (end.getTimeInMillis()-start.getTimeInMillis())/LOOPS);

	}

}
