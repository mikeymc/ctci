package com.ctci.lists;

public class MiddleNodeRemover {

    public void remove(ListNode nodeToRemove) {
        ListNode node = nodeToRemove;

        while (node != null && node.hasNext()) {
            node.setValue(node.getNext().getValue());
            if (!node.getNext().hasNext()) {
                node.setNext(null);
            }
            node = node.getNext();
        }
    }
}
