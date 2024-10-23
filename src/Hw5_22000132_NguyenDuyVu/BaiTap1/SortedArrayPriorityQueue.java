package Hw5_22000132_NguyenDuyVu.BaiTap1;

import java.util.NoSuchElementException;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K,E> {
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

    public SortedArrayPriorityQueue() {
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
        if (n >= defaultSize) {
            resizeArray();
        }
        ArrEntry<K, E> newEntry = new ArrEntry<>((K)key, (E)element);
        int i = n - 1;
        while (i >= 0 && array[i].getKey().compareTo((K) key) > 0) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = newEntry;
        n++;
        return newEntry;
    }

    private void resizeArray() {
        @SuppressWarnings("unchecked")
        ArrEntry<K, E>[] newArray = new SortedArrayPriorityQueue.ArrEntry[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public Entry min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        return array[0];
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        Entry<K, E> min = array[0];
        for (int i = 1; i < n; i++) {
            array[i - 1] = array[i];
        }
        n--;
        return min;
    }
}
