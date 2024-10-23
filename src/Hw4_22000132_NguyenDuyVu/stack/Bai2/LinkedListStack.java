package Hw4_22000132_NguyenDuyVu.stack.Bai2;

import java.util.Iterator;
import java.util.ListIterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
        Node (E element) {
            this.element = element;
            next = null;
        }
    }

    private Node stack = null;

    @Override
    public void push(E element) {
        Node newNode = new Node(element);
        if (stack == null) {
            stack = newNode;
        } else {
            newNode.next = stack;
            stack = newNode;
        }
    }

    @Override
    public E pop() {
        Node temp = stack;
        if (stack == null) {
            return null;
        } else {
            stack = stack.next;
            return temp.element;
        }
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node current = stack;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E data = current.element;
            current = current.next;
            return data;
        }
    }

}
