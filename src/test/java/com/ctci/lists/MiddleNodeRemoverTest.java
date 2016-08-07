package com.ctci.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MiddleNodeRemoverTest {
    MiddleNodeRemover remover;
    LinkedList list;

    @Before
    public void setUp() {
        remover = new MiddleNodeRemover();
        list = new LinkedList();
    }

    @Test
    public void removeNode_whenNodeIsLastNode_removesIt() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals("[1, 2, 3]", list.toString());

        remover.remove(list.getHead().getNext());

        assertEquals("[1, 3]", list.toString());
    }
}