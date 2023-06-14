package com.michael.stackofplates;

import java.util.ArrayList;
import java.util.Stack;

public class StackOfPlates {
    private int threshold;
    private int values = 0;
    public StackOfPlates(int threshold) {
        this.threshold = threshold;
    }
    ArrayList<Stack<Integer>> al = new ArrayList<>();
    public void push (int data) {
        if (values % threshold == 0) {
            al.add(new Stack<>());
        }
        al.get(values / threshold).push(data);
        values++;
    }

    public int pop() throws Exception {
        if (values == 0) {
            throw new Exception("nothing to pop");
        }
        values--;
        int value = al.get(values / threshold).pop();
        if (values % threshold == 0) {
            al.remove(values / threshold);
        }
        return value;
    }

    public void print() {
        for (Stack<Integer> stack : al) {
            System.out.print(stack);
        }
        System.out.println();
    }
}
