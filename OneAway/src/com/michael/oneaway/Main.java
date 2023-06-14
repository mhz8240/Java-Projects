package com.michael.oneaway;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("pale", "pile"));
        System.out.println(oneAway("pale", "le"));
        System.out.println(oneAway("pale", "pue"));
        System.out.println(oneAway("ple", "pale"));
        System.out.println(oneAway("pale", "pale"));
    }

    public static boolean oneAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        if (s1.length() - s2.length() == 0) {
            int count = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (s1.length() > s2.length()) {
            int count = 0;
            int j = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
                else {
                    j++;
                }
            }
        }
        else {
            int count = 0;
            int j = 0;
            for (int i = 0; i < s2.length(); i++) {
                if (s2.charAt(i) != s1.charAt(j)) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
                else {
                    j++;
                }
            }
        }
        return true;
    }
}
