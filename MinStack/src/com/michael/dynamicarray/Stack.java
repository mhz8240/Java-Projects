package com.michael.dynamicarray;


public class Stack {
    private Node head = null;
    private int min = Integer.MAX_VALUE;
    private java.util.Stack<Integer> stack = new java.util.Stack<>();
    public void push(int data) {
        Node node = new Node(data);
        if (data < min) {
            min = data;
        }
        stack.push(min);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    public int pop() {
        stack.pop();
        if (head == null) {
            System.out.println("Stack is empty");
            return 0;
        }
        Node currentNode = head;
        head = head.next;
        Integer data = currentNode.data;
        return currentNode.data;
    }
    public int min() {
        return stack.peek();
    }
}
