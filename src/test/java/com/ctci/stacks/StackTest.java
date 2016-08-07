package com.ctci.stacks;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StackTest {
    Stack subject;

    @Before
    public void setUp() {
        subject = new Stack();
    }

    @Test
    public void stackWorksNormally() {
        assertEquals(-1, subject.pop());

        subject.push(1);
        assertEquals(1, subject.pop());
        assertEquals(-1, subject.pop());

        subject.push(2);
        subject.push(3);
        subject.push(4);

        assertEquals(4, subject.pop());
        assertEquals(3, subject.pop());
        assertEquals(2, subject.pop());
        assertEquals(-1, subject.pop());
    }

    @Test
    public void handlesTenItems() {
        subject.push(1);
        subject.push(2);
        subject.push(3);
        subject.push(4);
        subject.push(5);
        subject.push(6);
        subject.push(7);
        subject.push(8);
        subject.push(9);
        subject.push(10);

        assertEquals(10, subject.pop());
        assertEquals(9, subject.pop());
        assertEquals(8, subject.pop());
        assertEquals(7, subject.pop());
        assertEquals(6, subject.pop());
        assertEquals(5, subject.pop());
        assertEquals(4, subject.pop());
        assertEquals(3, subject.pop());
        assertEquals(2, subject.pop());
        assertEquals(1, subject.pop());
        assertEquals(-1, subject.pop());
    }

    @Test
    public void isEmpty() {
        assertTrue(subject.isEmpty());

        subject.push(1);
        assertFalse(subject.isEmpty());

        subject.pop();
        assertTrue(subject.isEmpty());
    }

    @Test
    public void isFull() {
        assertFalse(subject.isFull());

        for (int i = 1; i < 11; i++) {
            assertFalse(subject.isFull());
            subject.push(i);
        }

        assertTrue(subject.isFull());

        subject.pop();
        assertFalse(subject.isFull());

        subject.push(1);
        assertTrue(subject.isFull());
    }
}