package Hw5_22000132_NguyenDuyVu.BaiTap1;

import java.util.NoSuchElementException;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K,E> {
    protected class NodeEntry<K,E> implements Entry<K,E> {
        private K key;
        private E element;
        private NodeEntry<K,E> next;
        public NodeEntry(K k, E e){
            key = k;
            element = e;
            next = null;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }
    }

    private NodeEntry<K,E> head;
    private NodeEntry<K,E> tail;
    private int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Entry insert(K key, E element) throws IllegalArgumentException {
        NodeEntry<K,E> newest = new NodeEntry<>((K)key, (E)element);
        if(isEmpty()){
            head = newest;
            tail = newest;
        } else {
            tail.next = newest;
            tail = newest;
        }
        n++;
        return newest;
    }

    @Override
    public Entry min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> current = head.next;
        while (current != null) {
            if (current.getKey().compareTo(min.getKey()) < 0) {
                min = current;
            }
            current = current.next;
        }
        return min;
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> minPrev = null;
        NodeEntry<K, E> current = head.next;
        NodeEntry<K, E> prev = head;
        while (current != null) {
            if (current.getKey().compareTo(min.getKey()) < 0) {
                min = current;
                minPrev = prev;
            }
            prev = current;
            current = current.next;
        }
        if (minPrev == null) {
            head = head.next;
        } else {
            minPrev.next = min.next;
        }
        n--;
        return min;
    }
}
