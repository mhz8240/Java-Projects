package com.michael.dynamicarray;

import java.util.Arrays;

public class DynamicArray<T> {
    private Object[] tArray = null;
    private int capacity;
    private int size;
    private static final int minCapacity = 4;
    private static final int maxCapacity = 8;

    public DynamicArray() {
        this.capacity = 4;
        this.size = 0;
        this.tArray = new Object[capacity];
    }

    //add to the end of the array
    public void add(T data) {
        if (size >= maxCapacity) {
            System.out.println("Out of capacity");
            return;
        }
        if (size >= capacity){
            resize();
        }
        tArray[size] = data;
        size++;
    }
    //insert into the position of the index
    public void insert(int index, T data) {
        if (size >= maxCapacity) {
            System.out.println("Out of capacity");
            return;
        }
        if (index > size || index < 0) {
            System.out.println("Index out of bounds");
            return;
        }
        if (size >= capacity){
            resize();
        }
        for (int i = size; i > index; i--) {
            tArray[i] = tArray[i - 1];
        }
        tArray[index] = data;
        size++;
    }

    public Object get(int index) {
        return tArray[index];
    }

    public void remove(int index) {
        if (size <= minCapacity) {
            System.out.println("Too small capacity");
            return;
        }
        if (index > size || index < 0) {
            System.out.println("Index out of bounds");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            tArray[i] = tArray[i + 1];
        }
        tArray[size - 1] = null;
        size--;
        if (size <= capacity / 4) {
            capacity /= 2;
            Object[] newIntArray = new Object[capacity];
            for (int i = 0; i < size; i++) {
                newIntArray[i] = tArray[i];
            }
            tArray = newIntArray;
        }

    }
    public void set(int index, T data) {
        tArray[index] = data;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    public int size() {
        return size;
    }
    public boolean contains(T data) {
        for (Object i : tArray) {
            if (i == data) {
                return true;
            }
        }
        return false;
    }
    private void resize() {
        capacity *= 2;
        Object[] newIntArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newIntArray[i] = tArray[i];
        }
        tArray = newIntArray;
    }
    @Override
    public String toString() {
        return "DynamicArray{" +
                "intArray=" + Arrays.toString(tArray) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
