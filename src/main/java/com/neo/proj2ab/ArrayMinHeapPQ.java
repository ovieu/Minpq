package com.neo.proj2ab;

public class ArrayMinHeapPQ<T> implements ExtrinsicMinPQ<T> {
    @Override
    public void add(T item, double priority) {

    }

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
}
