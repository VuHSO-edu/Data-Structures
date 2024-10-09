package Hw3_22000132_NguyenDuyVu.listInterface;

import java.util.Collections;
import java.util.Iterator;

public class SimpleLinkedList<T> implements ListInterface<T>{
    class Node{
        T datta;
        Node next;

        Node (T data){
            this.datta = data;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    private boolean checkIndex(int index){
        return index >= 0 && index < n;
    }

    @Override
    public void add(T data) {
        Node newNode = new Node(data);
        if (top == null){
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    @Override
    public T get(int index) {
        if (checkIndex(index)){
            Node temp = top;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.datta;
        } else throw new IndexOutOfBoundsException("Index out of bound");
    }

    @Override
    public void set(int index, T data) {
        if (checkIndex(index)){
            Node temp = top;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.datta = data;
        } else throw new IndexOutOfBoundsException("Index out of bound");

    }

    @Override
    public void remove(int index) {
        if (checkIndex(index)){
            if (index == 0){
                top = top.next;
            } else {
                Node temp = top;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            n--;
        } else throw new IndexOutOfBoundsException("Index out of bound");

    }

    @Override
    public void isContain(T data) {
        Node temp = top;
        for (int i = 0; i < n; i++) {
            if (temp.datta.equals(data)){
                System.out.println("The list contains " + data);
                return;
            }
            temp = temp.next;
        }
        System.out.println("The list does not contain " + data);

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
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = top;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T data = temp.datta;
                temp = temp.next;
                return data;
            }
        };
    }
}
