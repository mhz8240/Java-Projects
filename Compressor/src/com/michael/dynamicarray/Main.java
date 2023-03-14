package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "aaabbc";
        System.out.println(compressor(s));
    }
    public static String compressor(String s) {
        int count = 1;
        StringBuilder str = new StringBuilder();
        str.append(s.substring(0,1));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }
            else {
                if (count > 1) { ;
                    str.append("" + count);
                }
                str.append(s.substring(i, i + 1));
                count = 1;
            }
        }
        if (count > 1) {
            str.append("" + count);
        }
        if (str.length() == s.length()) {
            return s;
        }
        return str.toString();
    }
}
