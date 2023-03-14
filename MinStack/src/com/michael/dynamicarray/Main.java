package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Stack stack = new Stack();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
