package com.ctci.stacks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackWithMinTest {
    StackWithMin subject;

    @Before
    public void setUp() {
        subject = new StackWithMin();
    }
    @Test
    public void minTest() {
        subject.push(4);
        assertEquals(4, subject.min());

        subject.pop();
        assertEquals(-1, subject.min());

        subject.push(4);
        subject.push(2);
        subject.push(5);
        assertEquals(2, subject.min());

        subject.pop();
        assertEquals(2, subject.min());
    }
}