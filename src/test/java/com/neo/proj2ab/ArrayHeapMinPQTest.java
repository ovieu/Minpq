package com.neo.proj2ab;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayHeapMinPQTest {
    @Test
    public void buildTest() {
        ArrayMinHeapPQ<Integer> heapq = new ArrayMinHeapPQ<>();
    }

    @Test
    public void constructorTest() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ<>();
        int actual = pq.arrLen();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void getSmallestItemTest() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ<>();
        pq.add(1, 3);
        pq.add(6, 1);
        int actual = pq.getSmallest();
        int expected = 6;
        assertEquals(actual, expected);
    }

    @Test
    public void containsElementTest() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ<>();
        pq.add(1, 3);
        pq.add(3, 7);
        pq.add(9, 0);
        pq.add(2, -1);

        // items exist
        assertTrue(pq.contains(1));
        assertTrue(pq.contains(2));
        assertTrue(pq.contains(9));
        assertTrue(pq.contains(3));

        // items dont exist
        assertFalse(pq.contains(21));
        assertFalse(pq.contains(31));
    }
}
