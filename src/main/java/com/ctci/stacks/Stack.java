package com.ctci.stacks;

public class Stack {
    int[] stack;
    int pointer;

    public Stack() {
        stack = new int[10];
        pointer = 0;
    }


    public int pop() {
        if (pointer == 0) {
            return -1;
        }

        return stack[pointer--];
    }

    public void push(int i) {
        stack[++pointer] = i;
    }
}
