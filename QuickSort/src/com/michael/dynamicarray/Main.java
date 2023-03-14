package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] iArray = {30, 50, 20, 10, 70, 60, 80, 40};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(iArray, 0, iArray.length - 1);
        for (int i : iArray) {
            System.out.println(i);
        }
    }
}
