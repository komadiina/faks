package net.etfbl.collections;

import java.util.LinkedList;

public class LinkedListAsQueueTest {
	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(3);
		queue.offer(8);
		queue.offer(6);
		queue.offer(14);
		queue.offer(1);
		System.out.print("Uklanjanje: ");
		while (!queue.isEmpty())
			System.out.print(queue.poll() + " ");
	}
}
