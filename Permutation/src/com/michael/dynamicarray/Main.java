package com.michael.dynamicarray;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s1 = "abcd";
        String s2 = "acdb";
        String s3 = "aefg";
        System.out.println(permutation(s1, s2));
        System.out.println(permutation(s1, s3));
    }
    public static boolean permutation(String s1, String s2) {
        s1 = s1.toLowerCase(Locale.ROOT);
        s2 = s2.toLowerCase(Locale.ROOT);
        int[] iArray1 = new int[128];
        int[] iArray2 = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            int n = s1.charAt(i);
            iArray1[n]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int n = s2.charAt(i);
            iArray2[n]++;
        }
        int a = 'a';
        int z = 'z';
        for (int i = a; i < z; i++) {
            if (iArray1[i] != iArray2[i]) {
                return false;
            }
        }
        return true;
    }
}
