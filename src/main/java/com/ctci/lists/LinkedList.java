package com.ctci.lists;

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private ListNode current;

    public boolean isEmpty() {
        return head == null;
    }

    public LinkedList add(int i) {
        if (this.head == null) {
            this.head = new ListNode(i);
            this.current = this.head;
            this.tail = this.current;
        } else {
            ListNode node = new ListNode(i);
            this.tail.setNext(node);
            this.tail = node;
        }

        return this;
    }

    public int getNext() {
        if (isEmpty() || current == null) {
            return -1;
        }

        int value = current.getValue();
        current = current.getNext();
        return value;
    }

    public ListNode getHead() {
        return this.head;
    }

    public ListNode getTail() {
        return this.tail;
    }

    public boolean contains(int i) {
        ListNode current = this.head;

        while (current != null) {
            if (current.getValue() == i) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    public int nthToLast(int i) {
        NthNodeFinder finder = new NthNodeFinder();
        finder.findNth(this.head, i);

        return head.getSpecialNumber();
    }

    public String toString() {
        ListNode current = this.head;
        String s = "[";
        while (current != null) {
            s = s + current.getValue();
            current = current.getNext();
            if(current != null) {
                s = s + ", ";
            }
        }
        s = s + "]";

        return s;
    }
}

