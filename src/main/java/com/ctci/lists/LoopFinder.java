package com.ctci.lists;

public class LoopFinder {
    public int findFirstRepeatedValue(LinkedList circle) {
        ListNode current = circle.getHead();

        while (current.getSpecialNumber() == -1) {
            current.setSpecialNumber(0);
            current = current.getNext();
        }

        return current.getValue();
    }
}
