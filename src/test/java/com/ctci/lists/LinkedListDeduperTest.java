package com.ctci.lists;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class LinkedListDeduperTest {
    LinkedList linkedList;
    LinkedListDeduper deduper;

    @Before
    public void setUp() {
        linkedList = new LinkedList();
        deduper = new LinkedListDeduper();
    }

    @Test
    public void returnWithoutDuplicates_ifEmpty_returnsNull() {
        assertNull(deduper.returnWithoutDuplicates(linkedList));
    }

    @Test
    public void returnWithoutDuplicates_whenNoDuplicatesExist_returnsTheList() {
        linkedList
                .add(1)
                .add(2)
                .add(3);

        LinkedList newList = deduper.returnWithoutDuplicates(linkedList);

        assertEquals(newList.getNext(), 1);
        assertEquals(newList.getNext(), 2);
        assertEquals(newList.getNext(), 3);
        assertEquals(newList.getNext(), -1);
    }

    @Test
    public void returnWithoutDuplicates_whenDuplicatesExist_removesThem() {
        linkedList = new LinkedList();
        linkedList
                .add(1)
                .add(2)
                .add(3)
                .add(2)
                .add(2)
                .add(4)
                .add(5)
                .add(1)
                .add(5)
                .add(6)
                .add(6);

        LinkedList newList = deduper.returnWithoutDuplicates(linkedList);

        assertEquals(newList.getNext(), 1);
        assertEquals(newList.getNext(), 2);
        assertEquals(newList.getNext(), 3);
        assertEquals(newList.getNext(), 4);
        assertEquals(newList.getNext(), 5);
        assertEquals(newList.getNext(), 6);
        assertEquals(newList.getNext(), -1);
    }
}