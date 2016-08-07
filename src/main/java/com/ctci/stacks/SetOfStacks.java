package com.ctci.stacks;

public class SetOfStacks {
    private static int NUMBER_OF_STACKS = 10;

    Stack[] stacks;
    int size;
    int stackNumber;

    public SetOfStacks() {
        this.size = 0;
        this.stacks = new Stack[NUMBER_OF_STACKS];
        this.stacks[0] = new Stack();
        this.stackNumber = 0;
    }

    public void push(int i) {
        if (this.size == Stack.STACK_SIZE * NUMBER_OF_STACKS) {
            return;
        }

        if (stacks[stackNumber].isFull()) {
            stacks[++stackNumber] = new Stack();
        }

        stacks[stackNumber].push(i);
        this.size++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }

        if (stacks[stackNumber].isEmpty()) {
            stacks[stackNumber--] = null;
        }

        int poppedValue = this.stacks[stackNumber].pop();
        this.size--;
        return poppedValue;
    }

    public int size() {
        return this.size;
    }
}
