package com.michael.avltree;

public class AVLTree {
    class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            int height = 1;
        }

        public Node getMin(Node node) {
            if (node.left == null) {
                return node;
            }
            return getMin(node.left);
        }
        public Node getMax(Node node) {
            if (node.right == null) {
                return node;
            }
            return getMax(node.right);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    private Node head = null;
    public void insert(int data) {
        head = insert(data, head);
    }
    private Node insert(int data, Node node) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(data, node.left);
        }
        else if (data > node.data) {
            node.right = insert(data, node.right);
        }
        else {
            return node;
        }
        node.height = getHeight(node);
        int balance = getBalance(node);
        //LL, use rightRotate
        if (balance < -1 && data < node.left.data) {
            return rightRotate(node);
        }
        //LR
        else if (balance < -1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //
        else if (balance > 1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        //RR
        else if (balance > 1 && data > node.right.data) {
            return rightRotate(node);
        }

        return node;
    }
    private Node rightRotate(Node node) {
        Node t1 = node.left.right;
        Node head = node.left;
        head.right = node;
        node.left = t1;
        node.height = getHeight(node);
        head.height = getHeight(head);
        return head;

    }
    private Node leftRotate(Node node) {
        Node t1 = node.right.left;
        Node head = node.right;
        head.left = node;
        node.right = t1;
        node.height = getHeight(node);
        head.height = getHeight(head);
        return head;
    }
    private int getBalance(Node node) {
        return getHeight(node.right) - getHeight(node.left);
    }
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
    public void print() {
        print(head);
    }
    private void print(Node node) {
        if (node != null) {
            System.out.println(node);
            print(node.left);
            print(node.right);
        }

    }
}
