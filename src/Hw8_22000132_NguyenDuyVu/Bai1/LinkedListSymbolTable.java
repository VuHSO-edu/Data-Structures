package Hw8_22000132_NguyenDuyVu.Bai1;

import java.util.ArrayList;
import java.util.List;

public class LinkedListSymbolTable<Key extends Comparable<Key>, Value > extends AbstractSymbolTable {

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node top;
    private int N;



    @Override
    public void put(Comparable comparable, Object o) {
        Key key = (Key) comparable;
        Value value = (Value) o;
        for (Node x = top; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        top = new Node(key, value, top);
        N++;
    }

    @Override
    public Object get(Comparable comparable) {
        Key key = (Key) comparable;
        for (Node x = top; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable keys() {
        List<Key> keyList = new ArrayList<>();
        for (Node x = top; x != null; x = x.next) {
            keyList.add(x.key);
        }
        return keyList;
    }
}
