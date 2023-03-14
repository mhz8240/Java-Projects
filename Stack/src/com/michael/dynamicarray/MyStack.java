package com.michael.dynamicarray;

import java.util.ArrayList;

public class MyStack {
    private Node head = null;
    public void push(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    public int pop() {
        if (head == null) {
            System.out.println("Stack is empty");
            return 0;
        }
        Node currentNode = head;
        head = head.next;
        return currentNode.data;
    }
    public void print() {
        if (head == null) {
            System.out.println("List is empty");
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }
}
