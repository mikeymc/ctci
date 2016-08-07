package com.ctci.stacks;

public class Stack {
    public static int STACK_SIZE = 10;

    private int[] stack;
    private int pointer;

    public Stack() {
        this.stack = new int[STACK_SIZE];
        this.pointer = -1;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        return this.stack[this.pointer--];
    }

    public void push(int i) {
        if (!isFull()) {
            this.stack[++this.pointer] = i;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return this.stack[this.pointer];
    }

    public boolean isEmpty() {
        return this.pointer < 0;
    }

    public boolean isFull() {
        return this.pointer == STACK_SIZE - 1;
    }

    public String toString() {
        String s = "[";

        for (int i = 0; i < STACK_SIZE; i++) {
            s = s + stack[i];

            if (i < STACK_SIZE - 1) {
                s = s + ", ";
            }
        }

        s = s + "]";

        return s;
    }
}
