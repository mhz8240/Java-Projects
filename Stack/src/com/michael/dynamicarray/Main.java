package com.michael.dynamicarray;



public class Main {

    public static void main(String[] args) {
	// write your code here
        MyStack myStack = new MyStack();
        myStack.push(2);
        myStack.push(1);
        System.out.println("Popped: " + myStack.pop());
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println("Popped: " + myStack.pop());
        myStack.print();
    }
}
