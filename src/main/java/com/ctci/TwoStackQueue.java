package com.ctci;

import com.ctci.stacks.Stack;

public class TwoStackQueue {
    Stack stack1;
    Stack stack2;

    public TwoStackQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void enqueue(int i) {
        stack1.push(i);
    }

    public int dequeue() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int numToReturn = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return numToReturn;
    }
}
