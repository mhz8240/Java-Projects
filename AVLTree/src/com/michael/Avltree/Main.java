package com.michael.Avltree;

public class Main {

    public static void main(String[] args) {
	// write your code here
        AVLTree avlTree = new AVLTree();
        avlTree.insert(7);
        avlTree.insert(6);
        avlTree.insert(3);
        avlTree.print();
        avlTree.insert(2);
        avlTree.insert(1);
        System.out.println();
        avlTree.print();

    }
}
