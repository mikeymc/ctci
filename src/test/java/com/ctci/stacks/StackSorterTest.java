package com.ctci.stacks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackSorterTest {
    StackSorter subject;

    @Before
    public void setUp() {
        subject = new StackSorter();
    }

    @Test
    public void sortsAStack() {
        Stack stack = new Stack();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(6);
        stack.push(1);
        stack.push(9);
        stack.push(8);
        stack.push(2);
        stack.push(4);

        Stack result = subject.sort(stack);

        for (int i  = 1; i < 10; i++) {
            assertEquals(i, result.pop());
        }
    }
}