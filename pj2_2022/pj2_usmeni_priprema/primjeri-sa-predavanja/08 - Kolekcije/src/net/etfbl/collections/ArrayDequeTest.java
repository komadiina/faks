package net.etfbl.collections;

import java.util.ArrayDeque;

public class ArrayDequeTest {
	public static void main(String[] args) {
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(3);
		stack.push(9);
		stack.push(6);
		System.out.print("Skidanje sa steka: ");
		while (!stack.isEmpty())
			System.out.print(" " + stack.pop());

		ArrayDeque<Integer> fifoQueue = new ArrayDeque<Integer>();
		fifoQueue.offerLast(3);
		fifoQueue.offerLast(9);
		fifoQueue.offerLast(6);
		System.out.print("\nUzimanje iz FIFO reda: ");
		while (!fifoQueue.isEmpty())
			System.out.print(" " + fifoQueue.pollFirst());
	}
}
