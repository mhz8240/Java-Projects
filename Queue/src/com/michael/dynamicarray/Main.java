package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyQueue myQueue = new MyQueue();
        myQueue.add(3);
        myQueue.add(2);
        System.out.println("Removed: " + myQueue.remove());
        myQueue.add(1);
        System.out.println("Is empty: " + myQueue.isEmpty());
        System.out.println("Peek: " + myQueue.peek());
        myQueue.print();
    }
}
