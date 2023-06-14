package com.michael.urlify;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "  a bcd e  fg ";
        System.out.println(urlify(s));

    }

    public static String urlify(String str) {
        str = str.strip();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                String s1 = str.substring(0, i);
                String s2 = str.substring(i + 1, str.length());
                str = s1.concat("%20").concat(s2);
            }
        }
        return str;
    }
}
