package com.michael.binaryheap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.insert(35);
        binaryHeap.insert(29);
        binaryHeap.insert(42);
        System.out.println("Extracted: " + binaryHeap.extractMax());
//        binaryHeap.print();
        binaryHeap.printSortedQueueInPlace();
        binaryHeap.insert(50);
        binaryHeap.insert(60);
//        System.out.println();
//        binaryHeap.printSortedQueueInPlace();
        System.out.println();
        binaryHeap.printSortedQueueASC();
        binaryHeap.printSortedQueueDSC();
    }
}
