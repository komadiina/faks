package org.unibl.etf.threads.synchronization2;

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
	private int[] elements;
	private int top;

	public Stack(int capacity) {
		elements = new int[capacity];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = -1;
		}
		top = -1;
	}

	public synchronized boolean push(int el) {
		if (isFull())
			try {
				System.out.println("Waiting for push...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("push: e[" + ++top + "] = " + el);
		elements[top] = el;
		notify();
		return true;
	}

	public synchronized int pop() {
		if (isEmpty())
			try {
				System.out.println("Waiting for pop...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		int el = elements[top];
		System.out.println("pop: e[" + top + "] = " + el);
		elements[top] = 0;
		top--;
		notify();
		return el;
	}

	private synchronized boolean isEmpty() {
		return top < 0;
	}

	private synchronized boolean isFull() {
		return top >= elements.length - 1;
	}
}
