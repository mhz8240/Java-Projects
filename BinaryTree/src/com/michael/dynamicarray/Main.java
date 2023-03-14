package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(9,2386798);
        bst.add(6,5374690);
        bst.add(11,8367882);
        bst.add(5,5383898);
        bst.add(12,5374732);
        bst.add(3,5383892);
        bst.add(10,5976898);
        bst.add(7,5307420);
        bst.add(14,5367742);
        bst.remove(105);
        System.out.println(bst.get(3, bst.root));
        bst.inOrderTraversal(bst.root);
        System.out.println();
        System.out.println("Size: " + bst.size());
        System.out.println("Is empty: " + bst.isEmpty());
        System.out.println("Min: " + bst.getMin());
        System.out.println("Max: " + bst.getMax());
        bst.remove(5);
        bst.remove(11);
        bst.remove(7);
        bst.remove(3);
        bst.remove(14);
        bst.remove(6);
        bst.remove(9);
        bst.remove(12);
        bst.remove(10);
        System.out.println();
        bst.inOrderTraversal(bst.root);
        System.out.println(bst.get(5, bst.root));
    }
}
