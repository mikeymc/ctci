package com.ctci.stacks;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SetOfStacksTest {
    private SetOfStacks subject;

    @Before
    public void setUp() {
        subject = new SetOfStacks();
    }

    @Test
    public void basicPushingAndPopping() {
        for (int i = 1; i < 101; i++) {
            subject.push(i);
            assertEquals(i, subject.size());
        }

        for (int i = 100; i > 0; i--) {
            assertEquals(i, subject.pop());
            assertEquals(i-1, subject.size());
        }
    }

    @Test
    public void handlesPushingToFullStack() {
        for (int i = 1; i < 101; i++) {
            subject.push(i);
            assertEquals(i, subject.size());
        }

        subject.push(101);
        assertEquals(100, subject.size());

        for (int i = 100; i > 0; i--) {
            assertEquals(i, subject.pop());
            assertEquals(i-1, subject.size());
        }

        assertEquals(-1, subject.pop());
        assertEquals(-1, subject.pop());

        assertEquals(0, subject.size());
    }
}