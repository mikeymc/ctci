package com.ctci.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoopFinderTest {
    LinkedList circle;
    LoopFinder finder;

    @Before
    public void setUp() {
        circle = new LinkedList();
        finder = new LoopFinder();
    }

    @Test
    public void findsFirstRepeatedValue() {
        circle
                .add(1)
                .add(2)
                .add(3);

        ListNode head = circle.getHead();
        ListNode tail = circle.getTail();

        tail.setNext(head);

        assertEquals(1, finder.findFirstRepeatedValue(circle));
    }
}