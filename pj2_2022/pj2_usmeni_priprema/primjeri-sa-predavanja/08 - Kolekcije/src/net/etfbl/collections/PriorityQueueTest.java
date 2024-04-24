package net.etfbl.collections;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(1);
		pq.add(6);
		pq.add(15);
		pq.add(11);
		pq.add(3);
		System.out.print("Obilazak: ");
		for (Iterator<Integer> it = pq.iterator(); it.hasNext();) {
			Integer integer = (Integer) it.next();
			System.out.print(integer + " ");
		}
		System.out.print("\nUklanjanje:");
		while (!pq.isEmpty())
			System.out.print(pq.poll() + " ");
	}
}
