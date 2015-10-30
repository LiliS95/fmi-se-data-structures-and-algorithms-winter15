/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.si.sda.tests;

import com.fmi.se.dsa.implementations.LinkedListQueue;
import com.fmi.se.dsa.interfaces.Queue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Dimitar
 */
public class QueueTest {

    private Queue<Integer> queue;

    private static final Integer ONE = 1;
    private static final Integer TWO = 2;
    private static final Integer THREE = 3;

    @Before
    public void init() {
        queue = new LinkedListQueue<>();
    }

    @Test
    public void testPushAndPop() {
        queue.push(ONE);
        assertEquals(queue.pop(), ONE);

        queue.push(ONE);
        queue.push(TWO);
        assertEquals(queue.pop(), ONE);
        assertEquals(queue.pop(), TWO);

        assertNull(queue.pop());

        queue.push(ONE);
        queue.push(TWO);
        queue.push(THREE);

        assertEquals(queue.pop(), ONE);
        assertEquals(queue.pop(), TWO);
        assertEquals(queue.pop(), THREE);

        assertNull(queue.pop());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.push(ONE);
        assertFalse(queue.isEmpty());

        queue.push(TWO);
        queue.push(THREE);
        assertFalse(queue.isEmpty());

        queue.pop();
        queue.pop();
        queue.pop();
        assertTrue(queue.isEmpty());
    }

}
