package com.ctci.stacks;

import com.ctci.lists.OrderedList;

public class StackWithMin extends Stack {
    OrderedList orderedList;

    public StackWithMin() {
        super();
        orderedList = new OrderedList();
    }


    public int pop() {
        int numberToRemove = super.pop();

        this.orderedList.remove(numberToRemove);
        return numberToRemove;
    }

    public void push(int i) {
        super.push(i);

        try {
            orderedList.add(i);
        } catch(Exception e) {

        }
    }

    public int min() {
        return this.orderedList.peekMin();
    }
}
