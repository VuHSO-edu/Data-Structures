package Hw5_22000132_NguyenDuyVu.BaiTap1;

import java.util.NoSuchElementException;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K,E> {
    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;
        public ArrEntry(K k, E e) {
            key = k;
            element = e;
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

    private ArrEntry<K, E>[] array;
    int n = 0;
    int defaultSize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

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
        if (n >= array.length) {
            resizeArray();
        }
        ArrEntry<K, E> newEntry = new ArrEntry<>(key, element);
        array[n++] = newEntry;
        return newEntry;
    }

    private void resizeArray() {
        @SuppressWarnings("unchecked")
        ArrEntry<K, E>[] newArray = new ArrEntry[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public Entry min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        ArrEntry<K, E> min = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(min.getKey()) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }
        ArrEntry<K, E> min = array[minIndex];
        array[minIndex] = array[--n];
        array[n] = null;
        return min;
    }
}
