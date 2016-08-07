package com.ctci.lists;

public class LinkedListDeduper {

    // Todo: solve without a buffer
    public LinkedList returnWithoutDuplicates(LinkedList listWithDupes) {
        if (listWithDupes.isEmpty()) {
            return null;
        }

        LinkedList newList = new LinkedList();
        ListNode current = listWithDupes.getHead();

        while (current != null) {
            int contender = current.getValue();
            if (!newList.contains(contender)) {
                newList.add(contender);
            }
            current = current.getNext();
        }

        return newList;
    }
}
