package com.michael.dynamicarray;

public class MyQueue {
    private Node head = null;
    private Node tail = null;

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public int remove() {
        if (head == null) {
            System.out.println("Queue is empty");
            return 0;
        }
        if (head == tail) {
            Node currentNode = head;
            head = null;
            tail = null;
            return currentNode.data;
        }
        Node currentNode = head;
        head = head.next;
        return currentNode.data;
    }

    public void print() {
        if (head == null) {
            System.out.println("Queue is empty");
            return;
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

    public int peek() {
        if (head == null) {
            System.out.println("Queue is empty");
            return 0;
        }
        return head.data;
    }

}
