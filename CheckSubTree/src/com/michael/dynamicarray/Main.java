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

        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.add(9,2386798);
        bst2.add(6,5374690);
        bst2.add(11,8367882);


        BinarySearchTree bst3 = new BinarySearchTree();
        bst3.add(12,2386798);
        bst3.add(11,5374690);
        bst3.add(14,8367882);
        System.out.println(checkSubTree(bst2, bst));
        System.out.println(checkSubTree(bst3, bst));

    }
    public static boolean checkSubTree(BinarySearchTree b1, BinarySearchTree b2) {
        BinarySearchTree.Node node = b2.get(b1.root.key, b2.root);
        return isEqual(b1.root, node);
    }

    public static boolean isEqual(BinarySearchTree.Node b1, BinarySearchTree.Node b2) {
        if (b1 == null) {
            return true;
        }
        if (b2 == null) {
            return false;
        }
        if (b1.key != b2.key) {
            return false;
        }
        boolean left =  isEqual(b1.left, b2.left);
        boolean right =  isEqual(b1.right, b2.right);
        if (left == true && right == true) {
            return true;
        }
        return false;
    }
}
