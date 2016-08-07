package com.ctci.lists;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ejb.access.EjbAccessException;

import static org.junit.Assert.assertEquals;

public class OrderedListTest {
    private OrderedList list;

    @Before
    public void setUp() {
        list = new OrderedList();
    }

    @Test
    public void itStartsOffEmpty() {
        assertEquals(0, list.size());
    }

    @Test
    public void itKeepsTrackOfSizeWhenAddingAndRemovingStuff() throws Exception {
        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());

        list.remove();
        assertEquals(0, list.size());
    }

    @Test(expected = Exception.class)
    public void add_whenListIsFull_throwsException() throws Exception {
        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());

        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        assertEquals(10, list.size());

        list.add(1);
        assertEquals(10, list.size());
    }

    @Test
    public void remove_whenAlreadyEmpty_keepsSizeZero() throws Exception {
        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());

        list.remove();
        assertEquals(0, list.size());

        list.remove();
        assertEquals(0, list.size());
    }

    @Test
    public void toString_showsTheListOfItems() throws Exception {
        assertEquals("[]", list.toString());

        list.add(1);
        assertEquals("[1]", list.toString());

        list.add(2);
        assertEquals("[1, 2]", list.toString());
    }

    @Test
    public void removeMin_whenEmpty_returnsNegativeOne() {
        assertEquals(-1, list.removeMin());
    }

    @Test
    public void removeMin_givenNumbersAreEnteredInOrder_returnsSmallestNumber() throws Exception {
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(6);

        assertEquals(1, list.removeMin());
        assertEquals(3, list.removeMin());
        assertEquals(5, list.removeMin());
        assertEquals(6, list.removeMin());
        assertEquals(-1, list.removeMin());
    }

    @Test
    public void removeMin_givenNumbersAreEnteredOutOfOrder_returnsSmallestNumber() throws Exception {
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(5);

        assertEquals(1, list.removeMin());
        assertEquals(3, list.removeMin());
        assertEquals(5, list.removeMin());
        assertEquals(6, list.removeMin());
        assertEquals(-1, list.removeMin());
    }

    @Test(expected = Exception.class)
    public void rigorousTest() throws Exception {
        assertEquals(0, list.size());

        list.add(3);
        list.add(1);
        list.add(6);
        list.add(5);
        assertEquals(4, list.size());

        assertEquals(1, list.removeMin());
        assertEquals(3, list.removeMin());
        assertEquals(5, list.removeMin());
        assertEquals(6, list.removeMin());
        assertEquals(-1, list.removeMin());

        assertEquals(0, list.size());

        list.add(3);
        list.add(1);
        list.add(6);
        list.add(5);
        assertEquals(4, list.size());

        list.add(1);
        list.add(7);
        list.add(5);
        list.add(4);
        list.add(9);
        list.add(2);
        assertEquals(10, list.size());

        list.add(14);
        assertEquals(10, list.size());

        assertEquals(1, list.removeMin());
        assertEquals(1, list.removeMin());
        assertEquals(2, list.removeMin());
        assertEquals(3, list.removeMin());
        assertEquals(4, list.removeMin());
        assertEquals(5, list.removeMin());
        assertEquals(5, list.removeMin());
        assertEquals(6, list.removeMin());
        assertEquals(7, list.removeMin());
        assertEquals(9, list.removeMin());
        assertEquals(-1, list.removeMin());
    }

    @Test
    public void removeValue_takesThatValueFromTheList() throws Exception {
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(5);
        assertEquals(4, list.size());

        list.add(1);
        list.add(7);
        list.add(5);
        list.add(4);
        list.add(9);
        list.add(2);
        assertEquals(10, list.size());

        assertEquals("[1, 1, 2, 3, 4, 5, 5, 6, 7, 9]", list.toString());

        list.remove(3);
        assertEquals("[1, 1, 2, 4, 5, 5, 6, 7, 9]", list.toString());
    }

    @Test
    public void removeValue_whenValueIsNotInTheList_doesNothing() throws Exception {
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(5);
        assertEquals(4, list.size());

        list.add(1);
        list.add(7);
        list.add(5);
        list.add(4);
        list.add(9);
        list.add(2);
        assertEquals(10, list.size());

        assertEquals("[1, 1, 2, 3, 4, 5, 5, 6, 7, 9]", list.toString());

        list.remove(8);
        assertEquals("[1, 1, 2, 3, 4, 5, 5, 6, 7, 9]", list.toString());
        assertEquals(10, list.size());

        list.remove(9);
        assertEquals("[1, 1, 2, 3, 4, 5, 5, 6, 7]", list.toString());
        assertEquals(9, list.size());

    }

    @Test
    public void peekMin_returnsSmallestElement() throws Exception {
        assertEquals(-1, list.peekMin());

        list.add(3);
        assertEquals(3, list.peekMin());
        assertEquals(3, list.peekMin());

        list.removeMin();

        assertEquals(-1, list.peekMin());

        list.add(3);
        list.add(1);
        assertEquals(1, list.peekMin());

        list.removeMin();
        assertEquals(3, list.peekMin());

        list.removeMin();
        list.removeMin();
        assertEquals(-1, list.peekMin());
    }

    @Test
    public void peekMin_worksWhenOneValueIsAddedAndRemoved() throws Exception {
        assertEquals(-1, list.peekMin());
        list.add(4);

        assertEquals(4, list.peekMin());

        list.remove(4);
        assertEquals(-1, list.peekMin());
    }
}