package com.neo.proj2ab;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayMinHeapPQ<T extends Comparable<? super T>> implements ExtrinsicMinPQ<T> {
    private Node[] arr;
    private int next;
    private List<T> elements;

    public ArrayMinHeapPQ() {
        arr = new ArrayMinHeapPQ.Node[8];
        next = 1;   // the heap should start at index 1 for easy calculations
        elements = new ArrayList<>();
    }

    // start -> private helpers
    int arrLen() {
        return arr.length;
    }

    boolean lesser(int child, int parent) {
        ArrayMinHeapPQ.Node childNode = arr[child];
        ArrayMinHeapPQ.Node parenNode = arr[parent];
        return childNode.compareTo(parenNode) < 0;
    }

    private void exchange(int child, int parent) {
        ArrayMinHeapPQ.Node tempChild = arr[child];
        arr[child] = arr[parent];
        arr[parent] = tempChild;
    }

    // k is the index of the element added to the end of the pq
    private void swimUp(int k) {
        while (k > 1 && lesser(k, k / 2)) {
           exchange(k, k / 2);
           k = k / 2;
        }
    }

    @Override
    public void add(T item, double priority) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        arr[next] = new Node(item, priority);
        swimUp(next);
        elements.add(item);
        next++;
    }

    // end -> private helpers
    @Override
    public boolean contains(T item) {
        Collections.sort(elements);
        return Collections.binarySearch(elements, item) >= 0;
    }

    public boolean isEmpty() {
        return next == 1;
    }

    @Override
    public T getSmallest() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pq is empty");
        }
        return arr[1].getValue();
    }

    public boolean greater(int i, int j) {
        if (arr[j] == null) return false;
        return arr[i].compareTo(arr[j]) > 0;
    }

    public void swimDown(int k) {
        while (2*k <= next) {
            int j = 2*k;
            if (j < next && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    // if the current element at the smallest position is greater than its
    // children, keep pushing it down until it is lesser than both children
    @Override
    public T removeSmallest() {
        if (isEmpty()) throw new NoSuchElementException("pq is empty");
        T min = getSmallest();
        exchange(1, --next);
        arr[next] = null;
        swimDown(1);
        elements.remove(min);
        return min;
    }

    @Override
    public int size() {
        return next - 1;
    }

    @Override
    public void changePriority(T item, double priority) {
        if (item == null) throw new IllegalArgumentException("Cannot change null item");
        if (Double.isNaN(priority)) throw new IllegalArgumentException("Must be a number");

        if (!contains(item)) throw new NoSuchElementException("Does not contain the element");
    }

    private class Node implements Comparable<Node>{
        T value;
        double priority;

        public Node(T value, double priority) {
            this.value = value;
            this.priority = priority;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public double getPriority() {
            return priority;
        }

        public void setPriority(double priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", priority=" + priority +
                    '}';
        }

        @Override
        public int compareTo(Node other) {
           if (other == null) return -1;
           return Double.compare(this.getPriority(), other.getPriority());
        }
    }

    // private test methods
    @Test
    public void testAdd() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ<>();
        pq.add(1, 0);
        double actualPriority = pq.arr[1].getPriority();
        Integer actualValue = (Integer) pq.arr[1].getValue();
        Integer expectedValue = 1;
        assertEquals(actualValue.intValue(), expectedValue.intValue());
        assertEquals(Double.valueOf(actualPriority), Double.valueOf(0));
    }

    @Test
    public void lesserTest() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ<>();
        pq.add(1, 3);
        pq.add(1, 1);
        int comp = pq.arr[2].compareTo(pq.arr[1]);
        boolean comp2 = pq.lesser(2, 1);
        assertTrue(!comp2);
    }

    @Test
    public void exchangeTest() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ<>();
        pq.add(1, 3);
        pq.add(1, 1);
        double exp1 = pq.arr[1].getPriority();
        double actual = Double.valueOf(1);
        assertTrue(exp1 == actual);
    }

    @Test
    public void testSwimdown() {
        ArrayMinHeapPQ<Integer> pq = new ArrayMinHeapPQ();
        pq.add(23, 10);
        pq.add(-87, 2);
        pq.add(24, 0);
        // test if the element would move
        int actual = pq.arr[3].getValue();
        int expected = -87;
        assertEquals(expected, actual);

        pq.removeSmallest();
        actual = pq.arr[2].getValue();
        expected = 23;
        assertEquals(actual, expected);
    }
}
