package com.ctci.lists;

public class NumberAsListAdder {
    public LinkedList add(LinkedList list1, LinkedList list2) {
        return convertToList(convertToNumber(list1) + convertToNumber(list2));
    }

    private int convertToNumber(LinkedList list) {
        int sum = 0;
        int orderOfMagnitude = 1;
        int current = list.getNext();

        while (current > -1) {
            sum += current * orderOfMagnitude;
            orderOfMagnitude = orderOfMagnitude * 10;
            current = list.getNext();
        }

        return sum;
    }

    private LinkedList convertToList(int number) {
        LinkedList list = new LinkedList();

        while (number > 0) {
            list.add(number % 10);
            number = number / 10;
        }

        return list;
    }
 }
