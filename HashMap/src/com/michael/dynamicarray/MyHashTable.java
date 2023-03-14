package com.michael.dynamicarray;

import java.util.Arrays;

public class MyHashTable {
    private Data[] data;
    private int bucketSize = 8;
    private int size = 0;

    public MyHashTable() {
        this.data = new Data[bucketSize];
    }

    private class Data {
        String key;
        String value;
        final int hashCode;
        Data next;
        public Data(String key, String value, int hashCode) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.hashCode = hashCode;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    ", hashCode=" + hashCode +
                    ", next=" + next +
                    '}';
        }
    }


    public void put(String key, String value) {
        int index = getIndex(key);
        int hashCode = getHashCode(key);

        Data currentData = data[index];
        while (currentData != null) {
            if (key.equals(currentData.key) && hashCode == currentData.hashCode) {
                currentData.value = value;
                return;
            }
            currentData = currentData.next;
        }
        currentData = new Data(key, value, hashCode);
        currentData.next = data[index];
        data[index] = currentData;
        size++;
        if (getLoadFactor() >= 0.7) {
            resize();
        }
    }

    private void resize() {
        bucketSize *= 2;
        Data[] temp = data;
        data = new Data[bucketSize];
        size = 0;
        for (int i = 0; i < bucketSize/2; i++) {
            Data obj = temp[i];
            while(obj != null) {
                put(obj.key, obj.value);
                obj = obj.next;
            }
        }
    }
    private int getHashCode(String key) {
        return Math.abs(key.hashCode());
    }

    private int getIndex(String key) {
        // test collision
        if (key.equals("John") || key.equals("Jane")) {
            return 2;
        }
        return getHashCode(key) % bucketSize;
    }



    public String get(String key) {
        int index = getIndex(key);
        if (data[index] == null) {
            System.out.println("Can't find the given key");
            return null;
        }
        Data currentData = data[index];
        while (currentData != null) {
            if (currentData.key.equals(key)) {
                return currentData.value;
            }
            currentData = currentData.next;
        }
        System.out.println("Can't find the given key");
        return null;
    }

    public Data remove(String key) {
        int index = getIndex(key);
        Data currentData = data[index];
        if (currentData != null && currentData.key.equals(key)) {
            data[index] = data[index].next;
            size--;
            return currentData;
        }
        while (currentData.next != null) {
            if (currentData.next.key.equals(key)) {
                Data temp = currentData.next;
                currentData.next = currentData.next.next;
                size--;
                return temp;
            }
        }
        System.out.println("Can't find the given key");
        return null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    private double getLoadFactor() {
        return (double) getSize() / bucketSize;
    }

    @Override
    public String toString() {
        return "MyHashTable{" +
                "data=" + Arrays.toString(data) +
                ", bucketSize=" + bucketSize +
                ", size=" + size +
                '}';
    }
}
