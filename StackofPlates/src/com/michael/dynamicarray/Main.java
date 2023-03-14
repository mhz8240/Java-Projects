package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            StackOfPlates sop = new StackOfPlates(3);
            sop.push(1);
            sop.push(2);
            sop.push(3);
            sop.push(4);
            sop.push(5);
            sop.print();
            sop.pop();
            sop.pop();
            sop.pop();
            sop.pop();
            System.out.println(sop.pop());
//        sop.push(4);
            sop.print();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
