package com.michael.linkedlistduplicates;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(1);
        ll.add(2);
        System.out.println(removeDuplicates(ll));
    }

    public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> ll) { ;
        Iterator<Integer> itr = ll.iterator();
        Set<Integer> set = new HashSet<>();
        while (itr.hasNext()) {
            int i = itr.next();
            if (set.contains(i)) {
                itr.remove();
            }
            else {
                set.add(i);
            }
        }
        return ll;
    }

    /*
     public static LinkedList<Object> removeDuplicates(LinkedList<Integer> ll) {
        LinkedList<Object> linkedList = new LinkedList<>();
        Set<Integer> set = new LinkedHashSet<>(ll);
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            linkedList.add(itr.next());
        }
        return linkedList;
    }
    */
//    public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> ll) {
//        Set<Integer> set = new LinkedHashSet<>();
//        int size = ll.size();
//        for (int i = 0; i < ll.size(); i++) {
//            if (set.contains(ll.get(i))) {
//                ll.remove(i);
//                i--;
//            }
//            else {
//                set.add(ll.get(i));
//            }
//        }
//        return ll;
//    }
}
