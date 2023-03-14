package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Llist llist = new Llist();
        llist.addBack(6);
        llist.addFront(8);
        llist.addBack(7);
        System.out.println("Get front: " + llist.getFront());
        System.out.println("Get front: " + llist.getBack());
        System.out.println("Size: " + llist.size());
        System.out.println("Contains 7: " + llist.contains(7));
        System.out.println("Contains 9: " + llist.contains(9));
        llist.print();
        System.out.println();
        llist.remove(6);
        llist.print();

    }
}
