package com.neo.proj2ab;

import org.junit.Test;

import java.util.NoSuchElementException;

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

    @Test
    public void testSize() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ<>();
        assertTrue(pq.size() == 0);

        pq.add(1, 3);
        pq.add(3, 7);
        pq.add(9, 0);
        int actual = pq.size();
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveSmallestInEmpty() {
        // test it throws exception on empyt
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ<>();
        pq.removeSmallest();
    }

    @Test
    public void testGetSmallestItem() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ();
        // add one element
        pq.add(23, 0);
        int expected = 23;
        int actual = pq.removeSmallest();
        assertEquals(expected, actual);
        pq.removeSmallest();
        assertTrue(pq.isEmpty());

        // add more than two element
        pq.add(43, 5);
        pq.add(74, 0);
        pq.add(90, -1);
        expected = 90;
        actual = pq.removeSmallest();
        assertEquals(expected, actual);
    }
}
