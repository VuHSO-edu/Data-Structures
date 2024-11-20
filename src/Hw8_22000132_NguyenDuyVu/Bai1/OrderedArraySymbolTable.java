package Hw8_22000132_NguyenDuyVu.Bai1;

import java.util.LinkedList;
import java.util.Queue;

public class OrderedArraySymbolTable<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;


    @Override
    public Key min() {
        if (isEmpty()) return null;
        return keys[0];
    }

    @Override
    public Key max() {
        if (isEmpty()) return null;
        return keys[N - 1];
    }

    @Override
    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i - 1];

    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        if (i == N) return null;
        return keys[i];
    }

    @Override
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    @Override
    public Key select(int k) {
        if (k < 0 || k >= N) throw new IllegalArgumentException("Index out of bounds");
        return keys[k];
    }

    @Override
    public void deleteMin() {
        if (isEmpty()) return;
        delete(min());
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) return;
        delete(max());
    }

    @Override
    public int size(Key lo, Key hi) {
        if (lo == null || hi == null) throw new IllegalArgumentException("Arguments to size() cannot be null");
        if (lo.compareTo(hi) > 0) return 0;
        int rankLo = rank(lo);
        int rankHi = rank(hi);
        return rankHi - rankLo + (contains(hi) ? 1 : 0);
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null || hi == null) throw new IllegalArgumentException("Arguments to keys() cannot be null");
        Queue<Key> queue = new LinkedList<>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.add(keys[i]);
        }
        if (contains(hi)) queue.add(keys[rank(hi)]);
        return queue;
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    @Override
    public Value get(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            for (int j = i; j < N - 1; j++) {
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];
            }
            keys[N - 1] = null;
            values[N - 1] = null;
            N--;
        }
    }

    @Override
    public boolean contains(Key key) {
        return rank(key) < N && keys[rank(key)].compareTo(key) == 0;
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
    public Iterable<Key> keys() {
        return keys(min(), max());
    }
}
