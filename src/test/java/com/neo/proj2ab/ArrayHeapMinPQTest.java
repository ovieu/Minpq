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
}
