package com.michael.dynamicarray;

import javax.sound.sampled.Line;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(1);
        l1.add(0);
        l1.add(1);
        l1.add(1);
        l2.add(2);
        l2.add(0);
        l2.add(2);
        System.out.println(returnList(l1, l2));
//        System.out.println(sumLists(l1, l2));
    }

    public static LinkedList<Integer> sumLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> ll = new LinkedList<>();
        if (l1.size() > l2.size()) {
            addList(l1, l2, ll);
        }
        else {
            addList(l2, l1, ll);
        }

        return ll;
    }
    public static void addList(LinkedList<Integer> lMax, LinkedList<Integer> lMin, LinkedList<Integer> ll) {
        int sizeDifference = lMax.size() - lMin.size();
        int borrow = 0;
        for (int i = 0; i < lMin.size(); i++) {
                int sum = lMax.get(i) + lMin.get(i) + borrow;
                if (borrow > 0) {
                    borrow = 0;
                }
                if (sum >= 10) {
                    borrow++;
                }
                ll.add(sum % 10);
        }

        for (int i = 0; i < sizeDifference; i++) {
                ll.add(lMax.get(i + lMin.size()) + borrow);
                if (borrow > 0) {
                    borrow = 0;
                }
        }
        if (borrow > 0) {
            ll.add(borrow);
        }
    }
    public static LinkedList<Integer> returnList(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        int sum = convertListToInt(l1) + convertListToInt(l2);
        return convertIntToList(sum);
    }
    public static int convertListToInt(LinkedList<Integer> ll) {
        int sum = 0;
        for (int i = 0; i < ll.size(); i++) {
            sum += ll.get(i) * (int)Math.pow(10,i);
        }
        return sum;
    }
    public static LinkedList<Integer> convertIntToList(int n) {
        LinkedList<Integer> ll = new LinkedList<>();
        int digits = 0;
        while ((int)Math.pow(10, digits) < n) {
            int value = (n / (int)Math.pow(10, digits)) % 10;
            ll.add(value);
            digits++;
        }
        return ll;
    }
}
