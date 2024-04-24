package net.etfbl.collections;

import java.util.LinkedList;

public class LinkedListAsStack {
	public static void main(String[] args) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.push(3);
		stack.push(9);
		stack.push(6);
		System.out.print("Skidanje sa steka: ");
		while (!stack.isEmpty())
			System.out.print(" " + stack.pop());
	}
}
