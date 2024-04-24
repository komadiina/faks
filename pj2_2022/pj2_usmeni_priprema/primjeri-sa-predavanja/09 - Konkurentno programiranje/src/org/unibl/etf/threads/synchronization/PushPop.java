package org.unibl.etf.threads.synchronization;

public class PushPop extends Thread {
	private Stack stack;
	private int number;
	private String type;

	public PushPop(Stack stack, int number, String type) {
		this.type = type;
		this.stack = stack;
		this.number = number;
		setName(type);
	}

	public void run() {
		if (type.equals("PUSH"))
			for (int i = 0; i < number; i++) { // 1
				stack.push(i);
			}
		else
			for (int i = 0; i < number; i++) { // 2
				stack.pop();
			}
	}

	public static void main(String args[]) {
		Stack stack = new Stack(20); // 3
		PushPop pusher = new PushPop(stack, 30, "PUSH"); // 4
		PushPop popper = new PushPop(stack, 30, "POP"); // 5
		pusher.start(); // 6
		popper.start(); // 7
	}
}

class Stack {
	private int[] elements; // 1
	private int top; // 2

	public Stack(int capacity) {
		elements = new int[capacity];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = -1;
		}
		top = -1;
	}

//	public synchronized boolean push(int el) { // 3
//		if (isFull()) {// W
//			return false; // X
//		}
//		System.out.println("push: e[" + ++top + "] = " + el); // A
//		elements[top] = el; // B
//		return true;
//	}

	public boolean push(int el) {
		synchronized (this) {
			if (isFull()) {
				return false;
			}
			System.out.println("push: e[" + ++top + "] = " + el);
			elements[top] = el;
			return true;
		}
	}


	public synchronized int pop() { // 4
		if (isEmpty()) {// Y
			return 0; // Z
		}
		int el = elements[top]; // C
		System.out.println("pop: e[" + top + "] = " + el);
		elements[top] = 0;
		top--; // D
		return el;
	}

	private boolean isEmpty() { // 5
		return top < 0;
	}

	private boolean isFull() { // 6
		return top >= elements.length - 1;
	}
}

