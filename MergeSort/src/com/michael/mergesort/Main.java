package com.michael.mergesort;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] iArray = {6, 3, 4, 1, 7, 5, 2};
        mergeSort(0, iArray.length - 1, iArray);
        for (int i : iArray) {
            System.out.println(i);
        }
    }
    private static void merge(int front, int middle, int back, int[] iArray) {
        int n1 = middle + 1 - front;
        int n2 = back - middle;
        int[] sub1 = new int[n1];
        int[] sub2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            sub1[i] = iArray[front + i];
        }
        for (int j = 0; j < n2; j++) {
            sub2[j] = iArray[middle + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = front;
        while (i < n1 && j < n2) {
            if (sub1[i] < sub2[j]) {
                iArray[k] = sub1[i];
                i++;
            }
            else {
                iArray[k] = sub2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            iArray[k] = sub1[i];
            i++;
            k++;
        }
        while (j < n2) {
            iArray[k] = sub2[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int front, int back, int[] iArray) {
        if (front < back) {
            int middle = front + (back - front) / 2;
            mergeSort(front, middle, iArray);
            mergeSort(middle + 1, back, iArray);
            merge(front, middle, back, iArray);
        }
    }
}
