package com.ctci.lists;

public class ListNode {
    private int specialNumber;
    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.specialNumber = -1;
    }

    public ListNode getNext() {
        return this.next;
    }

    public int getSpecialNumber() {
        return this.specialNumber;
    }

    public void setSpecialNumber(int number) {
        this.specialNumber = number;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public void setNext(ListNode node) {
        this.next = node;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
