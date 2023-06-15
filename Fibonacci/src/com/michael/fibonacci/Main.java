package com.michael.fibonacci;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        System.out.println(fibonacciNaive(43));
        System.out.println(fibonacciM(43));
        System.out.println(fibonacciM(6));
    }

    public static int fibonacciNaive(int n) {
        if (n == 1) {
            return 0;
        }
        else if (n == 2) {
            return 1;
        }
        else {
            return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
        }
    }

    static boolean flag = true;
    static int[] iArray;
    public static int fibonacciM(int n) {
        iArray = new int[n + 1];
        return fibonacci(n);
    }
    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (iArray[n] == 0){
            iArray[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return iArray[n];
    }
}
