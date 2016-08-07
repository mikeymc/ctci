package com.ctci.lists;

public class OrderedList {
    int size;
    int[] list;

    public OrderedList() {
        size = 0;
        list = new int[10];

        for (int i = 0; i < list.length; i++) {
            list[i] = -1;
        }
    }

    public int size() {
        return size;
    }

    public void add(int numberToAdd) throws Exception {
        if (size == list.length) {
            throw new Exception();
        }

        int indexAtWhichToAddNumber = 0;

        boolean found = false;
        while (!found && indexAtWhichToAddNumber < this.size) {
            if (numberToAdd > list[indexAtWhichToAddNumber]) {
                indexAtWhichToAddNumber++;
            } else {
                found = true;
            }
        }

        for (int i = list.length - 1; i > indexAtWhichToAddNumber; i--) {
            list[i] = list[i - 1];
        }

        list[indexAtWhichToAddNumber] = numberToAdd;
        size++;
    }

    public int remove() {
        if (size > 0) {
            size--;
        }

        return 0;
    }

    public void remove(int number) {
        int currentIndex = 0;
        boolean found = false;

        while (!found && currentIndex < this.size) {
            if (list[currentIndex] == number) {
                found = true;
            } else {
                currentIndex++;
            }
        }

        if(found) {
            for (int i = currentIndex; i < this.list.length - 1; i++) {
                list[i] = list[i + 1];
            }

            size--;
        }
    }

    public int removeMin() {
        int min;
        if (size > 0) {
            min = this.list[0];

            for (int i = 0; i < this.list.length - 1; i++) {
                this.list[i] = this.list[i + 1];
            }

            size--;
            return min;
        }

        return -1;
    }

    public String toString() {
        String s = "[";

        for (int i = 0; i < this.size; i++) {
            s = s + list[i];

            if (i < this.size - 1) {
                s = s + ", ";
            }
        }

        s = s + "]";

        return s;
    }

    public int peekMin() {
        return this.list[0];
    }
}
