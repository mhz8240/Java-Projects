package com.michael.dynamicarray;

public class QuickSort {
    public void quickSort(int[] iArray, int front, int back) {
        if (front < back) {
            int partition = partition(iArray, front, back);
            quickSort(iArray, front, partition - 1);
            quickSort(iArray, partition + 1, back);
        }
    }

    private int partition(int[] iArray, int front, int back) {
        int pivot = iArray[back];
        int i = front - 1;
        for (int j = front; j <= back - 1; j++) {
            if (iArray[j] < pivot) {
                i++;
                swap(iArray, i, j);
            }
        }
        swap(iArray, i + 1, back);
        return i + 1;
    }

    private void swap(int[] iArray, int x, int y) {
        int temp = iArray[x];
        iArray[x] = iArray[y];
        iArray[y] = temp;
    }

}
