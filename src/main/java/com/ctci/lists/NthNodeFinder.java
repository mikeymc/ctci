package com.ctci.lists;

public class NthNodeFinder {
    public int findNth(ListNode node, int nthFromLast) {
        int count;
        if (!node.hasNext()) {
            count = 0;
        } else {
            count = 1 + findNth(node.getNext(), nthFromLast);
        }

        if (count == nthFromLast) {
            node.setSpecialNumber(node.getValue());
        } else if (node.hasNext() && node.getNext().getSpecialNumber() > -1) {
            node.setSpecialNumber(node.getNext().getSpecialNumber());
        }

        return count;
    }

}
