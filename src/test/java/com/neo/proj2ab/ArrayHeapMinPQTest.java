package com.neo.proj2ab;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
}
