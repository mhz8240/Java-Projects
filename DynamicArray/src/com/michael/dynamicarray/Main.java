package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
        // write your code here
        DynamicArray da = new DynamicArray<Integer>();
        System.out.println("Is empty: " + da.isEmpty());
        da.add(3);
        da.add(4);
        da.add(5);
        da.insert(1,6);
        da.insert(3,7);
//        System.out.println("Index 1: " + da.get(1));
//        System.out.println("Index 2: " + da.get(2));
        System.out.println(da);
        da.set(2,8);
        System.out.println("Size is " + da.size());
        System.out.println("Contains 5: " + da.contains(5));
        System.out.println("Contains 4: " + da.contains(4));

        System.out.println(da);

    }
}