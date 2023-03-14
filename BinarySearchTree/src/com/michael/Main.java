package com.michael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Tree<String> bst = new BinarySearchTree<>();

        bst.add("Adam");
        bst.add("Kevin");
        bst.add("Joe");
        bst.add("Michael");
        bst.add("Smith");

        bst.traversal();
        System.out.println("After deletion:");
        bst.delete("Joe");
        bst.delete("Smith");
        bst.traversal();
    }
}
