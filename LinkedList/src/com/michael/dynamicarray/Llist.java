package com.michael.dynamicarray;

public class Llist {
    private Node head;

    public void addFront(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void addBack(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    public int getFront() {
        if (head == null) {
            System.out.println("List is empty");
        }
        return head.data;
    }

    public int getBack() {
        if (head == null) {
            System.out.println("List empty");
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        Node currentNode = head;
        int size = 0;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;

    }

    public boolean contains(int data) {
        if (head == null) {
            return false;
        }
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == data) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void remove(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currentNode = head;
        if (head.data == data) {
            head = currentNode.next;
        }
        while (currentNode.next != null) {
            if (currentNode.next.data == data) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
        System.out.println("Couldn't find the data value in the list");
    }

    public void print() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }
}

