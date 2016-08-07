package com.ctci.lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberAsListAdderTest {

    @Test
    public void theExampleFromTheBook() {
        LinkedList list1 = new LinkedList();
        list1.add(3);
        list1.add(1);
        list1.add(5);

        LinkedList list2 = new LinkedList();
        list2.add(5);
        list2.add(9);
        list2.add(2);

        NumberAsListAdder adder = new NumberAsListAdder();
        LinkedList sum = adder.add(list1, list2);

        assertEquals("[8, 0, 8]", sum.toString());
    }
}