package Hw5_22000132_NguyenDuyVu.BaiTap1;

import java.util.NoSuchElementException;

public class SortedLinkedPriorityQueue<K extends Comparable,E> implements PriorityQueueInterface<K,E> {
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
        NodeEntry<K, E> newest = new NodeEntry<>((K) key, (E) element);
        if (isEmpty() || head.getKey().compareTo(newest.getKey()) > 0) {
            newest.next = head;
            head = newest;
        } else {
            NodeEntry<K, E> current = head;
            while (current.next != null && current.next.getKey().compareTo(newest.getKey()) <= 0) {
                current = current.next;
            }
            newest.next = current.next;
            current.next = newest;
        }
        n++;
        return newest;
    }

    @Override
    public Entry min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        return head;
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        NodeEntry<K, E> min = head;
        head = head.next;
        n--;
        return min;
    }
}
