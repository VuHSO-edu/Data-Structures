package Hw3_22000132_NguyenDuyVu.listInterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;


    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                System.out.println("Contain");
                return;
            }
        }
        System.out.println("Not Contain");
    }

    @Override
    public void remove(int index){
        if (checkIndex(index)){
            for (int i = index; i < n; i++) {
                array[i] = array[i + 1];
            }
            n--;
        } else {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }

    @Override
    public void set(int index, T data) {
        if (checkIndex(index)){
            array[index-1] = data;
        } else throw new IndexOutOfBoundsException("Index out of bound");

    }

    @Override
    public T get(int index) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        return array[index];
    }

    @Override
    public void add(T data) {
        if (n == array.length) {
            resize();
        }
        array[n++] = data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < n;
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }
        };
    }

    private void resize() {
        T[] temp = (T[]) new Object[array.length * 2];
        for (int i = 0; i < n; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < n;
    }
}
