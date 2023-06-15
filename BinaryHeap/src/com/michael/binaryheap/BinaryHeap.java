package com.michael.binaryheap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryHeap {
    int capacity = 10;
    int size = 0;
    int[] iArray = new int[capacity];
    public int leftChildIndex(int index) {
        return index * 2 + 1;
    }
    public int rightChildIndex(int index) {
        return index * 2 + 2;
    }
    public int parentIndex(int index) {
        return (index - 1) / 2;
    }
    public boolean hasLeftChild(int index) {
        if (leftChildIndex(index) >= 0 && leftChildIndex(index) < size) {
            return true;
        }
        return false;
    }
    public boolean hasRightChild(int index) {
        if (rightChildIndex(index) >= 0 && rightChildIndex(index) < size) {
            return true;
        }
        return false;
    }
    public boolean hasParent(int index) {
        if (parentIndex(index) >= 0 && parentIndex(index) < size) {
            return true;
        }
        return false;
    }
    public int leftChild(int index) {
        return iArray[leftChildIndex(index)];
    }
    public int rightChild(int index) {
        return iArray[rightChildIndex(index)];
    }
    public int parent(int index) {
        return iArray[(parentIndex(index))];
    }
    public void insert(int data) {
        checkSize();
        iArray[size] = data;
        size++;
        heapifyUp(size - 1);
    }
    public int extractMax() {
        int item = iArray[0];
        iArray[0] = iArray[size - 1];
        iArray[size-1] = 0;
        size--;

        heapifyDown();
        return item;
    }
    private void heapifyUp(int index) {
        while(hasParent(index) && parent(index) < iArray[index]) {
            swap(parentIndex(index), index);
            index = parentIndex(index);
        }
    }
    private void heapifyDown() {
        int index = 0;
        int childIndex = 0;
        while(hasLeftChild(index)) {
            childIndex = leftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) > leftChild(index)) {
                childIndex = rightChildIndex(index);
            }
            if (iArray[index] > iArray[childIndex]) {
                break;
            }
            else {
                swap(childIndex, index);
            }
            index = childIndex;
        }
    }
    private void checkSize() {
        if (size == capacity) {
            capacity *= 2;
            iArray = Arrays.copyOf(iArray, capacity);
        }
    }
    private void swap(int index1, int index2) {
        int temp = iArray[index1];
        iArray[index1] = iArray[index2];
        iArray[index2] = temp;
    }
    public void print() {
        for (int i : iArray) {
            System.out.println(i);
        }
    }
    public int size() {
        return size;
    }
    public void printSortedQueueInPlace() {
        int[] temp = Arrays.copyOf(iArray, capacity);
        int tempSize = size;
        for(int i = 0; i < tempSize; i++) {
            System.out.print(extractMax() + " ");
        }
        iArray = temp;
        size = tempSize;
    }
    public void printSortedQueueASC() {
        Stack<Integer> stack = new Stack<>();
        int[] temp = Arrays.copyOf(iArray, capacity);
        int tempSize = size;
        for(int i = 0; i < tempSize; i++) {
            stack.push(extractMax());
        }
        iArray = temp;
        size = tempSize;
        for (int i = 0; i < tempSize; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
    public void printSortedQueueDSC() {
        Queue<Integer> queue = new LinkedList<>();
        int[] temp = Arrays.copyOf(iArray, capacity);
        int tempSize = size;
        for(int i = 0; i < tempSize; i++) {
            queue.add(extractMax());
        }
        iArray = temp;
        size = tempSize;
        System.out.println(queue);
    }
}
