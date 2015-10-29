package com.fmi.si.sda.tests;

import com.fmi.se.dsa.implementations.LinkedListStack;
import com.fmi.se.dsa.interfaces.Stack;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Dimitar
 */
public class StackTest {

    private Stack<Integer> stack;
    private static final Integer ONE = 1;
    private static final Integer TWO = 2;
    private static final Integer THREE = 3;

    @Before
    public void initTest() {
        stack = new LinkedListStack<>();
    }

    @Test
    public void testPushAndPop() {
        stack.push(ONE);
        assertEquals(stack.pop(), ONE);

        stack.push(TWO);
        stack.push(THREE);
        assertEquals(stack.pop(), THREE);

        stack.pop();
        assertNull(stack.pop());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(ONE);
        assertFalse(stack.isEmpty());
    }
}
