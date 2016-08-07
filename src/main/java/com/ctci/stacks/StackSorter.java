package com.ctci.stacks;

public class StackSorter {
    Stack mainSortingStack;
    Stack backupSortingStack;

    public StackSorter() {
        mainSortingStack = new Stack();
        backupSortingStack = new Stack();
    }

    public Stack sort(Stack stack) {
        boolean sorted = false;
        int buffer;

        while (!sorted) {
            while (!stack.isEmpty()) {
                buffer = stack.pop();

                if (mainSortingStack.isEmpty() || mainSortingStack.peek() <= buffer) {
                    mainSortingStack.push(buffer);
                } else {
                    backupSortingStack.push(buffer);
                }
            }

            if (backupSortingStack.isEmpty()) {
                sorted = true;
                stack = finish(mainSortingStack);
            } else {
                stack = weave(stack, mainSortingStack, backupSortingStack);
            }
        }
        return stack;
    }

    private Stack finish(Stack from) {
        Stack to = new Stack();

        while (!from.isEmpty()) {
            to.push(from.pop());
        }

        return to;
    }

    private Stack weave(Stack stack, Stack mainSortingStack, Stack backupSortingStack) {
        while (!mainSortingStack.isEmpty() || !backupSortingStack.isEmpty()) {
            if (backupSortingStack.isEmpty() || mainSortingStack.peek() > backupSortingStack.peek()) {
                stack.push(mainSortingStack.pop());
            } else {
                stack.push(backupSortingStack.pop());
            }
        }

        return stack;
    }
}
