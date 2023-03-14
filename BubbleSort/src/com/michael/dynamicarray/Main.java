package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] iArray = new int[]{5, 2, 4, 3, 6, 7, 1};
        bubbleSort(iArray);
        for (int i : iArray) {
            System.out.println(i);
        }
    }
    public static void bubbleSort(int[] iArray) {
        for (int i = 0; i < iArray.length - 1; i++) {
            for (int j = 0; j < iArray.length - 1 - i; j++) {
                if (iArray[j] > iArray[j + 1]) {
                    swap(j, j + 1, iArray);
                }
            }
        }
    }
    private static void swap(int i, int j, int[] iArray) {
        int temp = iArray[i];
        iArray[i] = iArray[j];
        iArray[j] = temp;

    }
}

