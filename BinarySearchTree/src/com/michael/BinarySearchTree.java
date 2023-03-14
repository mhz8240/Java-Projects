package com.michael;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> head;
    @Override
    public void add(T data) {
        if (head == null) {
            head = new Node<T>(data);
        }
        else {
            add(data, head);
        }
    }

    @Override
    public void delete(T data) {
        if (head != null) {
            head = delete(data, head);
        }

    }

    @Override
    public void traversal() {
        if (head != null) {
            inOrderTraversal(head);
        }
    }

    private void add(T data, Node<T> node) {
        if (data.compareTo(node.getData()) == -1) {
            if (node.getLeft() != null) {
                add(data, node.getLeft());
            }
            else {
                node.setLeft(new Node<T>(data));
            }
        }
        else {
            if (node.getRight() != null) {
                add(data, node.getRight());
            }
            else {
                node.setRight(new Node<T>(data));
            }
        }
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeft() != null) {
            inOrderTraversal(node.getLeft());
        }
        System.out.println(node);
        if (node.getRight() != null) {
            inOrderTraversal(node.getRight());
        }
    }

    private Node<T> delete(T data, Node<T> node) {
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(data, node.getLeft()));
        }
        else if(data.compareTo(node.getData()) > 0) {
            node.setRight(delete(data, node.getRight()));
        }
        else {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            else if (node.getRight() == null) {
                return node.getLeft();
            }
            else if (node.getLeft() == null) {
                return node.getRight();
            }
            else {
                Node<T> predecessor = getPredecessor(node.getLeft());
                node.setData(predecessor.getData());
                node.setLeft(delete(predecessor.getData(), node));
            }
        }
        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRight() != null) {
            return getPredecessor(node.getRight());
        }
        return node;
    }
}
