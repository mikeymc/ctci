package com.ctci;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoStackQueueTest {
    TwoStackQueue subject;

    @Before
    public void setUp() {
        subject = new TwoStackQueue();
    }

    @Test
    public void test() {
        for (int i = 1; i < 11; i++) {
            subject.enqueue(i);
        }

        for (int i = 1; i < 11; i++) {
            assertEquals(i, subject.dequeue());
        }

        subject.enqueue(4);
        subject.enqueue(6);

        assertEquals(4, subject.dequeue());
        subject.enqueue(7);

        assertEquals(6, subject.dequeue());
        assertEquals(7, subject.dequeue());
    }
}