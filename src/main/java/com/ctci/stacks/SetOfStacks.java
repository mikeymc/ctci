package com.ctci.stacks;

public class SetOfStacks {
    Stack[] stacks;
    int size;
    int stackNumber;

    public SetOfStacks() {
        this.size = 0;
        this.stacks = new Stack[10];
        this.stacks[0] = new Stack();
        this.stackNumber = 0;
    }

    public void push(int i) {
        if(this.size == 100) {
            return;
        }

        if(stacks[stackNumber].isFull()) {
            stackNumber++;
            stacks[stackNumber] = new Stack();
        }

        stacks[stackNumber].push(i);
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public int pop() {
        if(size == 0) {
            return -1;
        }

        if(stacks[stackNumber].isEmpty()) {
            stacks[stackNumber] = null;
            stackNumber--;
        }

        int poppedValue = this.stacks[stackNumber].pop();
        this.size--;
        return poppedValue;
    }
}
