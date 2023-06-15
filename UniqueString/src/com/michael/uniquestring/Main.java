package com.michael.uniquestring;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String str1 = "abcd";
        String str2 = "abca";
        System.out.println(isUnique(str1));
        System.out.println(isUnique(str2));
    }

//    public static boolean isUnique(String str) {
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < str.length(); i++) {
//            int size = set.size();
//            set.add(str.charAt(i));
//            if (set.size() == size) {
//                return false;
//            }
//        }
//
//        return true;
//    }

//    public static boolean isUnique(String str) {
//        int[] iArray = new int[256];
//        for (int i = 0; i < str.length(); i++) {
//            int n = str.charAt(i);
//            iArray[n]++;
//            if (iArray[n] > 1) {
//                return false;
//            }
//
//
//
//        }
//        return true;
//    }

    public static boolean isUnique(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            hashMap.put(c, hashMap.get(c) == null ? 1 : hashMap.get(c) + 1);

        }
        boolean returnValue = true;
        for (char c : hashMap.keySet()) {
            System.out.println(hashMap.get(c));
            if (hashMap.get(c) > 1) {
                returnValue = false;
            }
        }
        return returnValue;

    }
}
