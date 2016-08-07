package com.ctci.lists;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class LinkedListTest {
    LinkedList linkedList;

    @Before
    public void setUp() {
        linkedList = new LinkedList();
    }

    @Test
    public void isEmpty_returnsTrueWhenListIsEmpty() throws Exception {
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void isEmpty_returnsFalseAfterAddingAValue() throws Exception {
        linkedList.add(1);

        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void getNext_returnsValuesInARow() {
        linkedList
                .add(1)
                .add(2)
                .add(3);

        assertEquals(linkedList.getNext(), 1);
        assertEquals(linkedList.getNext(), 2);
        assertEquals(linkedList.getNext(), 3);
        assertEquals(linkedList.getNext(), -1);
    }

    @Test
    public void contains_returnsTrueOrFalse() {
        linkedList
                .add(1)
                .add(2)
                .add(3);

        assertTrue(linkedList.contains(1));
        assertTrue(linkedList.contains(2));
        assertTrue(linkedList.contains(3));
        assertFalse(linkedList.contains(4));
        assertFalse(linkedList.contains(0));
    }

    @Test
    public void nthToLast() {
        linkedList
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .add(5)
                .add(6);

        assertEquals(6, linkedList.nthToLast(0));

        linkedList = new LinkedList();
        linkedList
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .add(5)
                .add(6);

        assertEquals(5, linkedList.nthToLast(1));

        linkedList = new LinkedList();
        linkedList
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .add(5)
                .add(6);

        assertEquals(4, linkedList.nthToLast(2));
    }
}
