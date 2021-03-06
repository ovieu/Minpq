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
        int expected = 8;
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
    public void removeSmallestItem() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ();
        pq.add(43, 3);
        pq.add(74, 4);
        pq.add(90, 0);
        pq.add(60, 1);

        int actual = pq.removeSmallest();
        assertEquals(90, actual);

        actual = pq.removeSmallest();
        assertEquals(60, actual);

        actual = pq.removeSmallest();
        assertEquals(43, actual);

        actual = pq.removeSmallest();
        assertEquals(74, actual);

        boolean isEmpty = pq.isEmpty();
        assertTrue(isEmpty);
    }

    @Test(expected = NoSuchElementException.class)
    public void changePriortyAbsentValueTest() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ<>();
        pq.add(43, 3);
        pq.add(74, 4);
        pq.changePriority(84, 2);
    }

    @Test
    public void changePriorityTest() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ();
        pq.add(90, 0);
        pq.add(60, 1);
        pq.add(38, 2);

        pq.changePriority(38, -1);
        int actual = pq.getSmallest();
        int expected = 38;
        assertEquals(actual, expected);

        pq.changePriority(60, -12);
        actual = pq.getSmallest();
        expected = 60;
        assertEquals(actual, expected);
    }
}
