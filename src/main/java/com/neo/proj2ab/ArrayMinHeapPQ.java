package com.neo.proj2ab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayMinHeapPQ<T extends Comparable> implements ExtrinsicMinPQ<T> {
    private Node[] arr;
    private int next;

    public ArrayMinHeapPQ() {
        arr = new ArrayMinHeapPQ.Node[5];
        next = 1;   // the heap should start at index 1 for easy calculations
    }

    // start -> private helpers
    int arrLen() {
        return arr.length;
    }

    @Override
    public void add(T item, double priority) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        arr[next] = new Node(item, priority);
        //swimUp(next);
        next++;
    }
    // end -> private helpers

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public T getSmallest() {
        return null;
    }

    @Override
    public T removeSmallest() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void changePriority(T item, double priority) {

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
}
